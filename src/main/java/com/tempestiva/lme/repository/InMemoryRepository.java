package com.tempestiva.lme.repository;

import com.tempestiva.lme.model.Point;
import com.tempestiva.lme.model.Robot;

import java.util.*;

public class InMemoryRepository implements MarsRepository {
    private Integer nextRobotId = 0;
    private Integer currentlyMovingRobot = 0;
    private List<Point> surface = new ArrayList<>();
    private Map<Integer, Robot> robots = new TreeMap<>();

    @Override
    public void setupSurface(final Point upperRight) {
        int totalPoints = upperRight.getX() * upperRight.getY();
        surface = new ArrayList<>(totalPoints);
        for (int i = 0; i < totalPoints; i++) {
            for (int x = 0; x < upperRight.getX(); x++) {
                for (int y = 0; y < upperRight.getY(); y++) {
                    surface.add(Point.builder().x(x).y(y).build());
                }
            }
        }
    }

    @Override
    public void addRobot(final Robot robot) {
        robots.put(robot.getId(), robot);
    }

    @Override
    public List<Point> getSurface() {
        return Collections.unmodifiableList(surface);
    }

    @Override
    public Map<Integer, Robot> getRobots() {
        return robots;
    }

    @Override
    public Robot getRobot(final Integer id) {
        return robots.get(id);
    }

    @Override
    public Integer getNextRobotId() {
        return nextRobotId++;
    }

    @Override
    public Integer getCurrentlyMovingRobot() {
        return currentlyMovingRobot;
    }
}
