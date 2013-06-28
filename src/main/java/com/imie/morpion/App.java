package com.imie.morpion;

import com.imie.morpion.model.Game;
import com.imie.morpion.view.Window;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */
public class App {

   public static void main(String[] args) throws Exception {
      Window window = new Window(new Game());
      window.setVisible(true);
   }
}
