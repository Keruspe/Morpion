package com.imie.morpion.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class ScoresPanel extends JPanel {

   private Label scoreMe;
   private Label scoreOther;

   private Label turn;

   public ScoresPanel() {
      super();
      this.setPreferredSize(new Dimension(420, 50));
      this.setBorder(LineBorder.createGrayLineBorder());
      this.add(createToolbar());
   }

   private JToolBar createToolbar() {
      ScoresToolBar toolbar = new ScoresToolBar();
      this.scoreMe = toolbar.addPlayer("Me");
      toolbar.addSeparator();
      this.scoreOther = toolbar.addPlayer("Other");
      toolbar.addSeparator();
      this.turn = new Label("", 120);
      toolbar.add(this.turn);
      return toolbar;

   }

   public void refresh(int scoreMe, int scoreOther, boolean me) {
      this.scoreMe.setText(scoreMe + "");
      this.scoreOther.setText(scoreOther + "");
      this.turn.setText((me) ? "My turn" : "Not my turn");
   }
}
