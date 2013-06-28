package com.imie.morpion.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class Label extends JLabel {

   public Label(String text) {
      super(text, RIGHT);
      this.setPreferredSize(new Dimension(75, 30));
   }
}
