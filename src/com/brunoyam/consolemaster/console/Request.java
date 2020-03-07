package com.brunoyam.consolemaster.console;

public enum Request {

    create(1, "create"),
    add(2, "add"),
    show(1, "show"),
    delete(1, "delete"),
    exit(0, "exit");

    private int argumentsNumber;
    private String command;

    Request(int argumentsNumber, String command) {
        this.argumentsNumber = argumentsNumber;
        this.command = command;
    }

    public int getArgumentsNumber() {
        return argumentsNumber;
    }

    public String getCommand() {
        return command;
    }

    public static Request findByCommand(String command) {

        for(Request request : values()) {
            if(request.getCommand().equals(command)) {
                return request;
            }
        }

        return null;

    }

}
