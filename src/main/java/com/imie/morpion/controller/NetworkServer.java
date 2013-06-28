package com.imie.morpion.controller;

import com.imie.morpion.model.Game;
import com.imie.morpion.model.SquareState;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class NetworkServer extends NetworkController {

   public NetworkServer(Game game, String id) throws IOException {
      super(game, SquareState.P1, id, new ServerSocket(4242).accept());
   }
}
