package com.imie.morpion.controller;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class NetworkServer extends NetworkController {

   public NetworkServer() throws IOException {
      super(new ServerSocket(4242).accept());
   }
}
