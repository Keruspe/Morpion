package com.imie.morpion.controller;

import com.imie.morpion.model.Game;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class NetworkServer extends NetworkController {

   public NetworkServer(Game game) throws IOException {
      super(game, new ServerSocket(4242).accept());
   }
}
