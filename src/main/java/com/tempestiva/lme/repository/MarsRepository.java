package com.tempestiva.lme.repository;

import com.tempestiva.lme.model.Point;
import com.tempestiva.lme.model.Robot;

import java.util.List;
import java.util.Map;

public interface MarsRepository {

    void setupSurface(Point upperRight);

    void addRobot(Robot robot);

    List<Point> getSurface();

    Map<Integer, Robot> getRobots();

    Robot getRobot(Integer id);

    Integer getNextRobotId();

    Integer getCurrentlyMovingRobot();
}
