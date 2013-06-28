package com.imie.morpion.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class ScoresPanel extends JPanel {

   private Label score1;
   private Label score2;

   public ScoresPanel() {
      super();
      this.setPreferredSize(new Dimension(300, 30));
      this.add(createToolbar());
   }

   private JToolBar createToolbar() {
      ScoresToolBar toolbar = new ScoresToolBar();
      this.score1 = toolbar.addPlayer("Me");
      this.score2 = toolbar.addPlayer("Other");
      return toolbar;
   }

   public void refresh(int score1, int score2) {
      this.score1.setText(score1 + "");
      this.score2.setText(score2 + "");
   }
}
