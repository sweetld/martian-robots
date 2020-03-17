package com.tempestiva.lme.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Position {
    Point point;
    Orientation orientation;

    public void move(Orientation orientation, int steps) {
        switch (orientation) {
            case N:
                point.y = point.y + steps;
                break;

            case E:
                point.x = point.x + steps;
                break;

            case S:
                point.y = point.y - steps;
                break;

            case W:
                point.x = point.x - steps;
                break;
        }
    }

    public void left() {
        orientation = Orientation.from((orientation == Orientation.N ? 360 : orientation.getDegree()) - Direction.L
            .getDegree());
    }

    public void right() {
        orientation = Orientation.from(orientation.getDegree() + Direction.R.getDegree());
    }

    public void forward(int steps) {
        move(orientation, steps);
    }
}
