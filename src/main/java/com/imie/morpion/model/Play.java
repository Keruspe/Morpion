package com.imie.morpion.model;

import java.io.Serializable;

/**
 * @author Marc-Antoine Perennou<Marc-Antoine@Perennou.com>
 */

public class Play implements Serializable {

   public String player;
   public int x;
   public int y;

   public Play(String player, int x, int y) {
      this.player = player;
      this.x = x;
      this.y = y;
   }
}
