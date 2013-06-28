package com.imie.morpion.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class Label extends JLabel {

   public Label(String text, int width) {
      super(text, CENTER);
      this.setPreferredSize(new Dimension(width, 30));
      this.setBorder(new EmptyBorder(5, 5, 5, 5));
   }

   public Label(String text) {
      this(text, 75);
   }
}
