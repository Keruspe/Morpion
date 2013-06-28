package com.imie.morpion.model;

/**
 * Created with IntelliJ IDEA.
 * User: hedrobino
 * Date: 6/28/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public enum SquareState {
    P1("O"),
    P2("X"),
    EMPTY("");

    private String value;
    private SquareState(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
