package com.imie.morpion.view;

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
    public Board() {
        this.setLayout(new GridLayout(3, 3));
        this.setSize(500, 500);

        this.add(new JLabel("O"));
        this.add(new JLabel("X"));
        this.add(new JLabel("O"));
        this.add(new JLabel("X"));
        this.add(new JLabel("O"));
        this.add(new JLabel("X"));
        this.add(new JLabel("O"));
        this.add(new JLabel("X"));
        this.add(new JLabel("O"));
    }
}
