package com.imie.morpion.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class NetworkClient extends NetworkController {

   public NetworkClient() {
      // TODO: lock
   }

   @Override
   protected void openSocket() {
      try {
         this.socket = new Socket(InetAddress.getByName("localhost"), 4242);
         this.input = new ObjectInputStream(this.socket.getInputStream());
         this.output = new ObjectOutputStream(this.socket.getOutputStream());
      } catch (IOException ex) {
         Logger.getLogger(NetworkClient.class.getName()).log(Level.SEVERE, null, ex);
      }
   }
}
