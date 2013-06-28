package com.imie.morpion.view;

import com.imie.morpion.model.Game;
import com.imie.morpion.model.SquareState;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: hedrobino
 * Date: 6/28/13
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */
public class Board extends JPanel {
    private JLabel[][] labels;

    public Board(int width, int height) {
        this.setLayout(new GridLayout(3, 3));
        this.setSize(width, height);

        labels = new JLabel[3][3];
        for(int i = 0; i < 9; i++) {
            JLabel l = new JLabel("");

            labels[i / 3][i % 3] = l;
            this.add(l);
        }
    }

    public void refresh(SquareState[][] squareStates) {
        for(int i = 0; i < 9; i++) {
            labels[i / 3][i % 3].setText(squareStates[i / 3][i % 3].toString());
        }
    }
}
