package com.brunoyam.consolemaster.service;

import com.brunoyam.consolemaster.console.Task;

public class ExitService implements TaskService {
    @Override
    public void doTask(Task task) {
        System.out.println("bye bye");
        System.exit(0);
    }
}
