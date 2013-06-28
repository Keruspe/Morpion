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

   public ScoresPanel() {
      super();
      this.setPreferredSize(new Dimension(310, 50));
      this.setBorder(LineBorder.createGrayLineBorder());
      this.add(createToolbar());
   }

   private JToolBar createToolbar() {
      ScoresToolBar toolbar = new ScoresToolBar();
      this.scoreMe = toolbar.addPlayer("Me");
      toolbar.addSeparator();
      this.scoreOther = toolbar.addPlayer("Other");
      return toolbar;
   }

   public void refresh(int scoreMe, int scoreOther) {
      this.scoreMe.setText(scoreMe + "");
      this.scoreOther.setText(scoreOther + "");
   }
}
