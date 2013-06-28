package com.imie.morpion.view;

import javax.swing.*;
import java.awt.*;

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

   public void addSeparator() {
      JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
      separator.setPreferredSize(new Dimension(3, 30));
      this.add(separator);
   }
}
