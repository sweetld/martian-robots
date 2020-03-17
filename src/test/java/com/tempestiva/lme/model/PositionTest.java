package com.tempestiva.lme.model;

import org.junit.Assert;
import org.junit.Test;

/*
Left: the robot turns left 90 degrees and remains on the current grid point.
Right: the robot turns right 90 degrees and remains on the current grid point.
Forward: the robot moves forward one grid point in the direction of the current orientation
and maintains the same orientation.
 */
public class PositionTest {

    @Test
    public final void whenFacingNorthMoveForwardYIncreases() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.N);
        position.move(position.getOrientation(), 1);
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(6, position.point.y);
    }

    @Test
    public final void whenFacingSouthMoveForwardYDecreases() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.S);
        position.move(position.getOrientation(), 1);
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(4, position.point.y);
    }

    @Test
    public final void whenFacingEastMoveForwardXIncreases() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.E);
        position.move(position.getOrientation(), 1);
        Assert.assertEquals(6, position.point.x);
        Assert.assertEquals(5, position.point.y);
    }

    @Test
    public final void whenFacingWestMoveForwardXDecreases() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.W);
        position.move(position.getOrientation(), 1);
        Assert.assertEquals(4, position.point.x);
        Assert.assertEquals(5, position.point.y);
    }

    @Test
    public final void whenFacingNorthTurnLeft() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.N);
        position.left();
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(5, position.point.y);
        Assert.assertEquals(Orientation.W, position.orientation);
    }

    @Test
    public final void whenFacingNorthTurnRight() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.N);
        position.right();
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(5, position.point.y);
        Assert.assertEquals(Orientation.E, position.orientation);
    }

    @Test
    public final void whenFacingSouthTurnLeft() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.S);
        position.left();
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(5, position.point.y);
        Assert.assertEquals(Orientation.E, position.orientation);
    }

    @Test
    public final void whenFacingSouthTurnRight() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.S);
        position.right();
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(5, position.point.y);
        Assert.assertEquals(Orientation.W, position.orientation);
    }

    @Test
    public final void whenFacingEastTurnLeft() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.E);
        position.left();
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(5, position.point.y);
        Assert.assertEquals(Orientation.N, position.orientation);
    }

    @Test
    public final void whenFacingEastTurnRight() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.E);
        position.right();
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(5, position.point.y);
        Assert.assertEquals(Orientation.S, position.orientation);
    }

    @Test
    public final void whenFacingWestTurnLeft() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.W);
        position.left();
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(5, position.point.y);
        Assert.assertEquals(Orientation.S, position.orientation);
    }

    @Test
    public final void whenFacingWestTurnRight() {
        Position position = new Position(Point.builder().x(5).y(5).build(), Orientation.W);
        position.right();
        Assert.assertEquals(5, position.point.x);
        Assert.assertEquals(5, position.point.y);
        Assert.assertEquals(Orientation.N, position.orientation);
    }
}
