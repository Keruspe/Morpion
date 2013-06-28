package com.imie.morpion.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class NetworkClient extends NetworkController {

   public NetworkClient() throws IOException {
      super(new Socket(InetAddress.getByName("localhost"), 4242));
      // TODO: lock
   }
}
