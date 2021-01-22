package com.tempestiva.lme.controller;

import com.tempestiva.lme.messagingstompwebsocket.RobotMessage;
import com.tempestiva.lme.messagingstompwebsocket.Status;
import com.tempestiva.lme.model.Robot;
import com.tempestiva.lme.service.MarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RobotController {
    private final MarsService marsService;

    @MessageMapping("/robot")
    @SendTo("/topic/status")
    public Status processCommand(RobotMessage message) throws Exception {
        Robot newRobot = marsService.addRobot(message);
        return new Status(newRobot.getId(), newRobot.getStartingPosition(), newRobot.getOldPosition(),"Created new Robot ID: " + newRobot.getId() );
    }
}
