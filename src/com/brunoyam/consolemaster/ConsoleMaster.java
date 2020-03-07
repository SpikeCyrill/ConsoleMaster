package com.brunoyam.consolemaster;

import com.brunoyam.consolemaster.console.ConsoleReader;
import com.brunoyam.consolemaster.service.CommandExecutorService;

public class ConsoleMaster {

    public static void main(String[] args) {

        CommandExecutorService commandExecutor = CommandExecutorService.getInstance();

        Thread thread = new Thread(commandExecutor);
        thread.start();

        ConsoleReader reader = new ConsoleReader(commandExecutor);
        reader.start();



    }

}
