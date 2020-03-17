package com.tempestiva.lme.controller;

import com.tempestiva.lme.messagingstompwebsocket.CommandMessage;
import com.tempestiva.lme.messagingstompwebsocket.Status;
import com.tempestiva.lme.model.Orientation;
import com.tempestiva.lme.model.Point;
import com.tempestiva.lme.model.Position;
import com.tempestiva.lme.service.MarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CommandController {
    private final MarsService marsService;

    @MessageMapping("/command")
    @SendTo("/topic/status")
    public Status processCommand(CommandMessage message) throws Exception {
        if (message.getCommand().contains("RUN")) {
            marsService.resetSimulation();
            marsService.sendUpdate(new Status(null,null,null, "Simulation Reset"));
            marsService.runSimulation();
            marsService.sendUpdate(new Status(null,null,null, "Simulation Started"));
            return new Status(null, null, null,"Simulation Completed");
        } else {
            return new Status(null, null, null,"Unrecognised command!");
        }
    }
}
