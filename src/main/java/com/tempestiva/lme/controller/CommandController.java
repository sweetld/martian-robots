package com.tempestiva.lme.controller;

import com.tempestiva.lme.messagingstompwebsocket.CommandMessage;
import com.tempestiva.lme.messagingstompwebsocket.Status;
import com.tempestiva.lme.model.Orientation;
import com.tempestiva.lme.model.Point;
import com.tempestiva.lme.model.Position;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class CommandController {

    @MessageMapping("/command")
    @SendTo("/topic/status")
    public Status processCommand(CommandMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        Position startingPosition = Position.builder()
                                            .orientation(Orientation.N)
                                            .point(Point.builder().x(0).y(0).build())
                                            .build();
        return new Status(startingPosition, "Command sent: " + HtmlUtils.htmlEscape(message.getCommand()) + "!");
    }
}
