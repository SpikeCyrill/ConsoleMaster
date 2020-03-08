package com.brunoyam.consolemaster.console;

import com.brunoyam.consolemaster.model.Task;

import java.util.Arrays;

public class RequestParser {

    public Task parseRequest(String userRequest) {

        String[] requestParts = userRequest.split(" ");

        if (requestParts.length == 0) return null;

        Request request = Request.findByCommand(requestParts[0]);

        if(request != null) {
            if(requestParts.length == request.getArgumentsNumber() + 1) {
                String[] arguments = copyArgs(requestParts);
                Task task = new Task(request, arguments);
                return task;
            } else {
                return null;
            }
        } else {
            return null;
        }

    }

    private String[] copyArgs(String[] requestParts) {
        if(requestParts.length < 2) {
            return new String[0];
        } else {
            return Arrays.copyOfRange(requestParts, 1, requestParts.length);
        }
    }

}
