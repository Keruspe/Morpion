package com.imie.morpion.view;

import com.imie.morpion.controller.BoardListener;
import com.imie.morpion.model.SquareState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: hedrobino
 * Date: 6/28/13
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class Board extends JPanel {
   private JButton[][] buttons;
   private ArrayList<BoardListener> listeners;

   public Board(int width, int height) {
      this.setLayout(new GridLayout(3, 3));
      this.setSize(500, 500);

      listeners = new ArrayList<>();

      buttons = new JButton[3][3];
      for (int i = 0; i < 9; i++) {
         JButton b = new JButton("");
         final int j = i;
         b.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                 for(BoardListener l : listeners) {
                    if(l != null) {
                       l.onClick(j / 3, j % 3);
                    }
                 }
            }

            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
         });

         buttons[i / 3][i % 3] = b;
         this.add(b);
      }
   }

   public void refresh(SquareState[][] squareStates) {
      for (int i = 0; i < 9; i++) {
         buttons[i / 3][i % 3].setText(squareStates[i / 3][i % 3].toString());
      }
   }

   public void addListener(BoardListener l) {
      listeners.add(l);
   }
   public void removeListener(BoardListener l) {
      listeners.remove(l);
   }
}
