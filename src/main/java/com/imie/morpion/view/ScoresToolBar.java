package com.imie.morpion.view;

import javax.swing.*;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class ScoresToolBar extends JToolBar {

   public ScoresToolBar() {
      super();
   }

   public Label addPlayer(String name) {
      this.add(new Label(name));
      Label score = new Label("");
      this.add(score);
      return score;
   }
}
