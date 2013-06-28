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
      boolean server = (args.length == 1 && args[0].compareTo("--server") == 0);
      NetworkController nc = (server) ? new NetworkServer() : new NetworkClient();
      nc.start();

      Window window = new Window(new Game());
      window.setVisible(true);
   }
}
