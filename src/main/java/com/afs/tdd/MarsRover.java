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
        if (command.equals(MOVE)){
            move();
        }
        else if (command.equals(TURN_LEFT)){
            turnLeft();
        }
        else if (command.equals(TURN_RIGHT)){
            turnRight();
        }else{
            throw new CommandNotDefinedException(ERROR);
        }
    }

    private void turnRight() {
        if(heading.equals(NORTH)){
            heading= EAST;
        }
        else if(heading.equals(SOUTH)){
            heading= WEST;
        }
        else if(heading.equals(EAST)){
            heading= SOUTH;
        }
        else if(heading.equals(WEST)){
            heading= NORTH;
        }
    }

    private void turnLeft() {
        if(heading.equals(NORTH)){
            heading= WEST;
        }
        else if(heading.equals(SOUTH)){
            heading= EAST;
        }
        else if(heading.equals(EAST)){
            heading= NORTH;
        }
        else if(heading.equals(WEST)){
            heading= SOUTH;
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
