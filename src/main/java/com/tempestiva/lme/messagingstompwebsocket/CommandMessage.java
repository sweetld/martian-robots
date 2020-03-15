package com.tempestiva.lme.messagingstompwebsocket;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommandMessage {
    String command;
}
