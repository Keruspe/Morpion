package com.imie.morpion.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class NetworkServer extends NetworkController {

   @Override
   protected void openSocket() {
      try {
         ServerSocket server = new ServerSocket(4242);
         this.socket = server.accept();
         this.output = new ObjectOutputStream(this.socket.getOutputStream());
         this.input = new ObjectInputStream(this.socket.getInputStream());
      } catch (IOException ex) {
         Logger.getLogger(NetworkServer.class.getName()).log(Level.SEVERE, null, ex);
         return;
      }
   }
}
