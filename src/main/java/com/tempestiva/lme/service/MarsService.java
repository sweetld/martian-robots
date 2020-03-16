package com.tempestiva.lme.service;

import com.tempestiva.lme.messagingstompwebsocket.RobotMessage;
import com.tempestiva.lme.messagingstompwebsocket.SetupMessage;
import com.tempestiva.lme.messagingstompwebsocket.Status;
import com.tempestiva.lme.model.Position;
import com.tempestiva.lme.model.Robot;
import com.tempestiva.lme.repository.InMemoryRepository;
import com.tempestiva.lme.repository.MarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class MarsService {
    private MarsRepository marsRepository = new InMemoryRepository();
    @Autowired
    private SimpMessagingTemplate template;

    public String  setupSurface(final SetupMessage message) {
        marsRepository.setupSurface(message.getUpperRight());
        return "Created Mars Surface with " + marsRepository.getSurface().size() + "  Points.";
    }

    public Robot addRobot(final RobotMessage message) {
        Position startingPosition = Position.builder().point(message.getStartingPoint()).orientation(message.getOrientation()).build();
        Robot robot = Robot.builder().startingPosition(startingPosition).id(marsRepository.getNextRobotId()).build();
        marsRepository.addRobot(robot);
        return robot;
    }

    public void runSimulation() {
        Status update = new Status(1, null, "Update");
        template.convertAndSend("/topic/greetings", update);

    }
}
