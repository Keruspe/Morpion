package com.imie.morpion.model;

import com.imie.morpion.controller.ViewListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class Game {

   public List<ViewListener> listeners;

   public int score1;
   public int score2;

   public SquareState[][] squares;

   public Game() {
      this.listeners = new ArrayList<ViewListener>();

      this.score1 = 0;
      this.score2 = 0;

      squares = new SquareState[3][3];
      for (int i = 0; i < 9; i++) {
         squares[i / 3][i % 3] = SquareState.EMPTY;
      }
   }

   public void subscribe(ViewListener listener) {
      this.listeners.add(listener);
   }

   public void notifAll() {
      for (ViewListener listener : this.listeners) {
         listener.onViewChanged();
      }
   }
}
