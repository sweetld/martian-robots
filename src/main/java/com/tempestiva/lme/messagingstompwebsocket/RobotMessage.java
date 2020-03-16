package com.tempestiva.lme.messagingstompwebsocket;

import com.tempestiva.lme.model.Orientation;
import com.tempestiva.lme.model.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RobotMessage {
    Point startingPoint;
    Orientation orientation;
    String commands;
}
