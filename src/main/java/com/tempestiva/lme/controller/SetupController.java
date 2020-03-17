package com.tempestiva.lme.controller;

import com.tempestiva.lme.messagingstompwebsocket.SetupMessage;
import com.tempestiva.lme.messagingstompwebsocket.Status;
import com.tempestiva.lme.service.MarsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SetupController {
    private final MarsService marsService;

    @MessageMapping("/setup")
    @SendTo("/topic/status")
    public Status processCommand(SetupMessage message) throws Exception {
        return new Status(null, null, null, marsService.setupSurface(message));
    }
}
