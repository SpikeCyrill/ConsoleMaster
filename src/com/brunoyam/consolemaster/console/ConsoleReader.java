package com.brunoyam.consolemaster.console;

import com.brunoyam.consolemaster.service.CommandExecutor;

import java.util.Scanner;

public class ConsoleReader {

    private CommandExecutor ces;

    public ConsoleReader(CommandExecutor ces) {
        this.ces = ces;
    }

    public void start() {
        System.out.println("reader starts");

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()) {
            String input = scanner.nextLine();

            RequestParser requestParser = new RequestParser();
            Task task = requestParser.parseRequest(input);

            if(task == null) {
                System.out.println("not valid command");
            } else {
                ces.addTask(task);
            }

        }

    }


}
