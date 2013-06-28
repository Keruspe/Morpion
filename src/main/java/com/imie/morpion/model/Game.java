package com.imie.morpion.model;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class Game {

   public int score1;
   public int score2;

   public SquareState[][] squares;

   public Game() {
      this.score1 = 0;
      this.score2 = 0;

      squares = new SquareState[3][3];
      for(int i = 0; i < 9; i++) {
          squares[i / 3][i % 3] = SquareState.EMPTY;
      }
   }
}
