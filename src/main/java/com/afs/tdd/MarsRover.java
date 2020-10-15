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
        if (command.equals("R")){
            turnRight();
        }
    }

    private void turnRight() {
        if(heading.equals("N")){
            heading="E";
        }
        else if(heading.equals("S")){
            heading="W";
        }
        else if(heading.equals("E")){
            heading="S";
        }
        else if(heading.equals("W")){
            heading="N";
        }
    }

    private void turnLeft() {
        if(heading.equals("N")){
            heading="W";
        }
        else if(heading.equals("S")){
            heading="E";
        }
        else if(heading.equals("E")){
            heading="N";
        }
        else if(heading.equals("W")){
            heading="S";
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
