package com.imie.morpion.controller;

import com.imie.morpion.model.Game;
import com.imie.morpion.model.SquareState;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class NetworkClient extends NetworkController {

   public NetworkClient(Game game, String id) throws IOException {
      super(game, SquareState.P2, id, new Socket(InetAddress.getByName("localhost"), 4242));
      // TODO: lock
   }
}
