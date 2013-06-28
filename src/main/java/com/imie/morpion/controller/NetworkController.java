package com.imie.morpion.controller;

import com.imie.morpion.model.Game;
import com.imie.morpion.model.Play;
import com.imie.morpion.model.SquareState;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public abstract class NetworkController extends Thread implements BoardListener {

   private Game game;
   private SquareState player;
   private String id;
   private Socket socket;
   private InputStream input;
   private ObjectOutputStream output;

   protected NetworkController(Game game, SquareState player, String id, Socket socket) throws IOException {
      this.game = game;
      this.player = player;
      this.id = id;
      this.socket = socket;
      this.input = this.socket.getInputStream();
      this.output = new ObjectOutputStream(this.socket.getOutputStream());
   }

   @Override
   public void run() {
      try {
         ObjectInputStream input = new ObjectInputStream(this.input);
         String line;
         while (this.socket.isConnected()) {
            line = input.readUTF();
            if (line.startsWith("JOIN")) {
               this.game.join(line.split(" ")[1], this.player.getOtherPlayer());
            } else if (line.startsWith("PLAY")) {
               Play play = null;
               try {
                  play = (Play) input.readObject();
                  this.game.play(play);
               } catch (ClassNotFoundException ex) {
                  Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
               }
               // TODO: unlock
            } else if (line.startsWith("BYE")) {
               this.socket.close();
            }
         }
      } catch (SocketException e) {
         Logger.getLogger(NetworkController.class.getName()).info("Disconnected");
      } catch (IOException ex) {
         Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void joinGame() {
      try {
         this.output.writeUTF("JOIN " + this.id);
         this.output.flush();
         this.game.join(this.id, this.player);
      } catch (IOException ex) {
         Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void play(int x, int y) {
      Play play = new Play(this.id, x, y);
      try {
         this.output.writeUTF("PLAY");
         this.output.writeObject(play);
         this.output.flush();
         this.game.play(play);
         // TODO: lock
      } catch (IOException ex) {
         Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void quit() {
      if (this.socket.isConnected()) {
         try {
            this.output.writeUTF("BYE");
            this.output.flush();
            this.output.close();
            this.socket.close();
         } catch (IOException ex) {
         }
      }
   }

   @Override
   public void onClick(int x, int y) {
      play(x, y);
   }
}
