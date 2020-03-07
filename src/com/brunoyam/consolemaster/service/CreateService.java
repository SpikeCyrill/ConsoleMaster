package com.brunoyam.consolemaster.service;

import com.brunoyam.consolemaster.console.Task;
import com.brunoyam.consolemaster.dao.FileManipulator;

import java.io.File;

public class CreateService implements TaskService {

    public void doTask(Task task) {
        FileManipulator fileManipulator = new FileManipulator();

        String fileName = task.getArguments()[0];
        File file = new File(fileName);

        fileManipulator.createFile(file);

    }

}
