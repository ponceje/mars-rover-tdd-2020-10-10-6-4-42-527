package com.afs.tdd;


import java.util.Arrays;

public class MarsRover {
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
        Arrays.asList(commands.split(""))
                .forEach(command -> this.executeCommand(command));
    }

    public void executeCommand(String command){
        if (command.equals("M")){
            move();
        }
        if (command.equals("L")){
            turnLeft();
        }
    }

    private void turnLeft() {
        if(heading.equals("N")){
            heading="W";
        }
        if(heading.equals("S")){
            heading="E";
        }
    }

    private void move() {
        if (heading.equals("N")){
            locationY +=1;
        }
        if (heading.equals("S")){
            locationY -=1;
        }
        if (heading.equals("E")){
            locationX +=1;
        }
        if (heading.equals("W")){
            locationX -=1;
        }
    }


}
