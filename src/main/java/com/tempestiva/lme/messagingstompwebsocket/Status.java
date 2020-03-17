package com.tempestiva.lme.messagingstompwebsocket;

import com.tempestiva.lme.model.Position;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Status {
    Integer robotId;
    Position currentPosition;
    Position oldPosition;
    String message;
}
