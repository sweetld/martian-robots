package com.tempestiva.lme.controller;

import com.tempestiva.lme.messagingstompwebsocket.RobotMessage;
import com.tempestiva.lme.messagingstompwebsocket.SetupMessage;
import com.tempestiva.lme.messagingstompwebsocket.Status;
import com.tempestiva.lme.model.Orientation;
import com.tempestiva.lme.model.Point;
import com.tempestiva.lme.model.Position;
import com.tempestiva.lme.model.Robot;
import com.tempestiva.lme.service.MarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RobotController {
    private final MarsService marsService;

    @MessageMapping("/robot")
    @SendTo("/topic/status")
    public Status processCommand(RobotMessage message) throws Exception {
        Robot newRobot = marsService.addRobot(message);
        return new Status(newRobot.getId(), newRobot.getStartingPosition(), newRobot.getOldPosition(),"Created new Robot!" );
    }
}
