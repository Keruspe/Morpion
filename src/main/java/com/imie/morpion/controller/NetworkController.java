package com.imie.morpion.controller;

import com.imie.morpion.model.Play;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public abstract class NetworkController extends Thread {

   private Socket socket;
   private InputStream input;
   private ObjectOutputStream output;

   protected NetworkController(Socket socket) throws IOException {
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
            if (line.startsWith("PLAY")) {
               Play play = null;
               try {
                  play = (Play) input.readObject();
               } catch (ClassNotFoundException ex) {
                  Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
               }
               // TODO: apply + unlock
            } else if (line.startsWith("BYE")) {
               // TODO: quit
            }
         }
      } catch (IOException ex) {
         Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void play(Play play) {
      try {
         this.output.writeUTF("PLAY");
         this.output.writeObject(play);
         this.output.flush();
         // TODO: lock
      } catch (IOException ex) {
         Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
      }
   }

   public void quit() {
      try {
         this.output.writeUTF("BYE");
         this.output.flush();
         this.output.close();
      } catch (IOException ex) {
         Logger.getLogger(NetworkController.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
