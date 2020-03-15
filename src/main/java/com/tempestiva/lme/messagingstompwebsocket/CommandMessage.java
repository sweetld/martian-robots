package com.tempestiva.lme.messagingstompwebsocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandMessage {
    String command;
}
