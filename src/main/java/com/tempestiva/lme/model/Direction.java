package com.tempestiva.lme.model;

public enum Direction {
    L(90),
    R(90),
    F(0);

    private int degree;

    Direction(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }
}
