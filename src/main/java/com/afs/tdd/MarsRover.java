package com.afs.tdd;


import java.util.Arrays;

public class MarsRover {
    public static final String MOVE = "M";
    public static final String TURN_LEFT = "L";
    public static final String TURN_RIGHT = "R";
    public static final String ERROR = "error";
    public static final String NORTH = "N";
    public static final String EAST = "E";
    public static final String SOUTH = "S";
    public static final String WEST = "W";
    private int locationX;
    private int locationY;
    private String heading;


    public MarsRover(int locationX, int LocationY, String heading) {
        this.locationX = locationX;
        this.locationY = LocationY;
        this.heading = heading;
    }

    public int getLocationX() {
        return locationX;
    }
    public int getLocationY() {
        return locationY;
    }
    public String getHeading() {
        return heading;
    }

    public void executeCommands(String commands) {
        Arrays.asList(commands.split("")).forEach(command -> {
            try {
                executeCommand(command);
            } catch (CommandNotDefinedException e) {
                e.printStackTrace();
            }
        });
    }

    public void executeCommand(String command) throws CommandNotDefinedException {
        switch (command) {
            case MOVE:
                move();
                break;
            case TURN_LEFT:
                turnLeft();
                break;
            case TURN_RIGHT:
                turnRight();
                break;
            default:
                throw new CommandNotDefinedException(ERROR);
        }
    }

    private void turnRight() {
        switch (heading) {
            case NORTH:
                setHeading(EAST);
                break;
            case SOUTH:
                setHeading(WEST);
                break;
            case EAST:
                setHeading(SOUTH);
                break;
            case WEST:
                setHeading(NORTH);
                break;
        }
    }


    private void turnLeft() {
        switch (heading) {
            case NORTH:
                setHeading(WEST);
                break;
            case SOUTH:
                setHeading(EAST);
                break;
            case EAST:
                setHeading(NORTH);
                break;
            case WEST:
                setHeading(SOUTH);
                break;
        }
    }

    private void move() {
        if (heading.equals(NORTH)){
            moveUp();
        }
        if (heading.equals(SOUTH)){
            moveDown();
        }
        if (heading.equals(EAST)){
            moveRight();
        }
        if (heading.equals(WEST)){
            moveLeft();
        }
    }

    private void setHeading(String direction) {
        heading = direction;
    }

    private void moveUp() {
        locationY +=1;
    }
    private void moveDown() {
        locationY -=1;
    }
    private void moveRight() {
        locationX +=1;
    }
    private void moveLeft(){
        locationX -=1;
    }


}
