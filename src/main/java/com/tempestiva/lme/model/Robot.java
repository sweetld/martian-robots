package com.tempestiva.lme.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Robot {
    Integer id;
    Position currentPosition;
    Position startingPosition;
    String commands;

    public void walk(Runnable callback) {
        currentPosition = startingPosition;
        for (int i = 0; i < commands.length(); i++){
            // simulated delay
            try {
                Thread.sleep(1000);
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
            }
            callback.run();
        }
    }

}
