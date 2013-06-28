package com.imie.morpion;

import com.imie.morpion.controller.NetworkClient;
import com.imie.morpion.controller.NetworkController;
import com.imie.morpion.controller.NetworkServer;
import com.imie.morpion.model.Game;
import com.imie.morpion.view.Window;

import java.util.UUID;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */
public class App {

   public static void main(String[] args) throws Exception {
      Game game = new Game();
      String id = UUID.randomUUID().toString();

      boolean server = (args.length == 1 && args[0].compareTo("--server") == 0);
      NetworkController nc = (server) ? new NetworkServer(game, id) : new NetworkClient(game, id);
      nc.start();
      nc.joinGame();

      Window window = new Window(game);
      window.setVisible(true);
   }
}
