package com.imie.morpion.model;

import com.imie.morpion.view.GameListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class Game {

   public List<GameListener> listeners;

   private int score1;
   private int score2;

   private SquareState[][] squares;
   private GameState state;

   private Map<String, SquareState> players;

   public Game() {
      this.listeners = new ArrayList<GameListener>();
      this.players = new HashMap<String, SquareState>();

      this.score1 = 0;
      this.score2 = 0;
      this.state = GameState.P1_TURN;

      squares = new SquareState[3][3];
      for (int i = 0; i < 9; i++) {
         squares[i / 3][i % 3] = SquareState.EMPTY;
      }
   }

   public SquareState[][] getSquares() {
      return this.squares;
   }

   public int getScore1() {
      return score1;
   }

   public int getScore2() {
      return score2;
   }

   public void subscribe(GameListener listener) {
      this.listeners.add(listener);
   }

   public void onSquaresUpdate() {
      for(GameListener l : listeners) {
         l.onSquaresUpdate();
      }
   }
   public void onStateUpdate() {
      for(GameListener l : listeners) {
         l.onStateUpdate();
      }
   }

   public void join(String id, SquareState player) {
      this.players.put(id, player);
   }

   public void play(Play play) {
      if (squares[play.x][play.y] != SquareState.EMPTY)
         return;

      SquareState player = this.players.get(play.player);
      if ((state == GameState.P1_TURN && player == SquareState.P1)
            || (state == GameState.P2_TURN && player == SquareState.P2)) {
         squares[play.x][play.y] = player;
      }

      this.onSquaresUpdate();
      calculateState();
   }

   private void calculateState() {
      for (int i = 0; i < 3; i++) {
         /* Horizontal check */
         if (squares[0][i] == SquareState.P1 && squares[1][i] == SquareState.P1 && squares[2][i] == SquareState.P1) {
            state = GameState.P1_WIN;
            return;
         } else if (squares[0][i] == SquareState.P2 && squares[1][i] == SquareState.P2 && squares[2][i] == SquareState.P2) {
            state = GameState.P2_WIN;
            return;
         }
         /* Vertical check */
         else if (squares[i][0] == SquareState.P1 && squares[i][1] == SquareState.P1 && squares[i][2] == SquareState.P1) {
            state = GameState.P1_WIN;
            return;
         } else if (squares[i][0] == SquareState.P2 && squares[i][1] == SquareState.P2 && squares[i][2] == SquareState.P2) {
            state = GameState.P2_WIN;
            return;
         }
      }

      /* First diagonal check */
      if (squares[0][0] == SquareState.P1 && squares[1][1] == SquareState.P1 && squares[2][2] == SquareState.P1) {
         state = GameState.P1_WIN;
         return;
      } else if (squares[0][0] == SquareState.P2 && squares[1][1] == SquareState.P2 && squares[2][2] == SquareState.P2) {
         state = GameState.P2_WIN;
         return;
      }

      /* Second diagonal check */
      if (squares[2][0] == SquareState.P1 && squares[1][1] == SquareState.P1 && squares[0][2] == SquareState.P1) {
         state = GameState.P1_WIN;
         return;
      } else if (squares[2][0] == SquareState.P2 && squares[1][1] == SquareState.P2 && squares[0][2] == SquareState.P2) {
         state = GameState.P2_WIN;
         return;
      }

      /* Tie check */
      boolean all = true;
      for (int i = 0; i < 9; i++) {
         int x = i / 3;
         int y = i % 3;
         if (squares[i / 3][i % 3].equals(SquareState.EMPTY)) {
            all = false;
            break;
         }
      }

      if (all) {
         state = GameState.TIE;
      } else if (state.equals(GameState.P1_TURN)) {
         state = GameState.P2_TURN;
      } else {
         state = GameState.P1_TURN;
      }

      this.onStateUpdate();
   }
}
