package com.imie.morpion;

import com.imie.morpion.controller.NetworkClient;
import com.imie.morpion.controller.NetworkController;
import com.imie.morpion.controller.NetworkServer;
import com.imie.morpion.model.Game;
import com.imie.morpion.view.Window;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.UUID;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */
public class App {

   public static void main(String[] args) throws Exception {
      Game game = new Game();
      String id = UUID.randomUUID().toString();

      boolean server = (args.length == 1 && args[0].compareTo("--server") == 0);
      final NetworkController nc = (server) ? new NetworkServer(game, id) : new NetworkClient(game, id);

      Window window = new Window(game, nc, (server) ? "server" : "client");
      window.setVisible(true);

      nc.start();
      nc.joinGame();
      window.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent winEvt) {
            nc.quit();
         }
      });
   }
}
