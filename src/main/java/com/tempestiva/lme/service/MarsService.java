package com.tempestiva.lme.service;

import com.tempestiva.lme.messagingstompwebsocket.RobotMessage;
import com.tempestiva.lme.messagingstompwebsocket.SetupMessage;
import com.tempestiva.lme.messagingstompwebsocket.Status;
import com.tempestiva.lme.model.Position;
import com.tempestiva.lme.model.Robot;
import com.tempestiva.lme.repository.InMemoryRepository;
import com.tempestiva.lme.repository.MarsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MarsService {
    private final MarsRepository marsRepository = new InMemoryRepository();
    private final SimpMessagingTemplate template;

    public String setupSurface(final SetupMessage message) {
        marsRepository.setupSurface(message.getUpperRight());
        marsRepository.clearRobots();
        return "Created Mars Surface with " + marsRepository.getSurface().size() + "  Points.";
    }

    public Robot addRobot(final RobotMessage message) {
        Position startingPosition = Position.builder()
                                            .point(message.getStartingPoint())
                                            .orientation(message.getOrientation())
                                            .build();
        Robot robot = Robot.builder()
                           .startingPosition(startingPosition)
                           .currentPosition(startingPosition.toBuilder().build())
                           .oldPosition(startingPosition.toBuilder().build())
                           .commands(message.getCommands())
                           .id(marsRepository.getNextRobotId())
                           .build();
        marsRepository.addRobot(robot);
        return robot;
    }

    public void sendUpdate(Robot robot) {
        Status update = new Status(robot.getId(), robot.getCurrentPosition(), robot.getOldPosition(), "Update for Robot ID: " + robot.getId());
        template.convertAndSend("/topic/status", update);
    }

    public void sendUpdate(Status status) {
        template.convertAndSend("/topic/status", status);
    }

    public void runSimulation() {
        marsRepository.getRobots().forEach((index, robot) -> {
            robot.walk(() -> sendUpdate(robot));
            sendUpdate(new Status(robot.getId(), robot.getCurrentPosition(), robot.getOldPosition(), robot.isLost() ? "Result Lost" : "Result"));
        });
    }

    public void resetSimulation() {
        marsRepository.getRobots().forEach((index, robot) -> robot.reset());
    }
}
