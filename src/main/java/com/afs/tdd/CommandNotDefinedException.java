package com.afs.tdd;

public class CommandNotDefinedException extends Exception {
    public CommandNotDefinedException(String s) {
        super(s);
    }
}
