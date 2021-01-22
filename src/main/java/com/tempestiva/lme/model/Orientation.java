package com.tempestiva.lme.model;

import java.util.Arrays;

public enum Orientation {
    N(0),
    E(90),
    S(180),
    W(270);

    private final int degree;

    Orientation(int degree) {
        this.degree = degree;
    }

    public static Orientation from(final int degree) {
        return Arrays.stream(Orientation.values())
                     .filter(orientation -> orientation.getDegree() == degree)
                     .findFirst()
                     .orElse(Orientation.N);
    }

    public int getDegree() {
        return degree;
    }
}
