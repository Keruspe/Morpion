package com.imie.morpion.controller;

import com.imie.morpion.model.Game;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class NetworkClient extends NetworkController {

   public NetworkClient(Game game) throws IOException {
      super(game, new Socket(InetAddress.getByName("localhost"), 4242));
      // TODO: lock
   }
}
