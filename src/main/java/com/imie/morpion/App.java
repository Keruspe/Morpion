package com.imie.morpion;

import com.imie.morpion.controller.NetworkClient;
import com.imie.morpion.controller.NetworkController;
import com.imie.morpion.controller.NetworkServer;
import com.imie.morpion.model.Game;
import com.imie.morpion.view.Window;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */
public class App {

   public static void main(String[] args) throws Exception {
      Game game = new Game();

      boolean server = (args.length == 1 && args[0].compareTo("--server") == 0);
      NetworkController nc = (server) ? new NetworkServer(game) : new NetworkClient(game);
      nc.start();

      Window window = new Window(game);
      window.setVisible(true);
   }
}
