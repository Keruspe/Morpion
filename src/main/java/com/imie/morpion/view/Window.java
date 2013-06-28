package com.imie.morpion.view;

import com.imie.morpion.controller.BoardListener;
import com.imie.morpion.model.SquareState;

import javax.swing.*;
import java.awt.*;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */
public class Window extends JFrame implements GameListener {

   private ScoresPanel scores;
   private Board board;

   public Window(String title) throws Exception {
      super("Morpion " + title);

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

      this.scores = new ScoresPanel();
      this.add(scores, BorderLayout.PAGE_START);

      this.board = new Board(500, 500);
      this.add(board);
   }

   public void addBoardListener(BoardListener listener) {
      this.board.addListener(listener);
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

   @Override
   public void onSquaresUpdate(SquareState[][] squares) {
      this.board.refresh(squares);
   }

   @Override
   public void onStateUpdate(int scoreMe, int scoreOther, boolean me) {
      this.scores.refresh(scoreMe, scoreOther, me);
   }
}
