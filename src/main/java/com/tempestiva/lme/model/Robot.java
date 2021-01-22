package com.tempestiva.lme.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Robot {
    Integer id;
    Position currentPosition;
    Position startingPosition;
    Position oldPosition;
    String commands;
    @Builder.Default
    boolean lost = false;

    public void reset() {
        currentPosition = startingPosition;
        oldPosition = startingPosition;
    }

    public void walk(Runnable callback) {
        if (commands == null) {
            return;
        }
        oldPosition = currentPosition;
        currentPosition = startingPosition;
        for (int i = 0; i < commands.length(); i++){
            // simulated delay
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            char c = commands.charAt(i);
            switch (c) {
                case 'L':
                    currentPosition.left();
                    break;

                case 'R':
                    currentPosition.right();
                    break;

                case 'F':
                    currentPosition.forward(1);
                    break;

                default:
            }
            callback.run();
        }
    }

}
