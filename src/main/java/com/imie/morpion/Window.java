package com.imie.morpion;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */
public class Window extends JFrame {

   public Window() throws Exception {
      super("Morpion");

      String[] lookAndFeels = {
            "com.sun.java.swing.plaf.gtk.GTKLookAndFeel",
            "com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
            "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel",
            "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
            "javax.swing.plaf.metal.MetalLookAndFeel"
      };

      integrate:
      {
         for (String name : lookAndFeels) {
            if (this.checkLookAndFeel(name))
               break integrate;
         }
         throw new Exception("No LookAndFeel");
      }

      this.setLayout(new BorderLayout());
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      this.setSize(new Dimension(1220, 820));
   }

   private Boolean checkLookAndFeel(String name) {
      try {
         UIManager.setLookAndFeel(name);
         return true;
      } catch (RuntimeException ex) {
         return false;
      } catch (Exception ex) {
         return false;
      }
   }

   public void refresh(Game game) {

   }
}
