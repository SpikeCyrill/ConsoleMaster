package com.brunoyam.consolemaster.config;

import com.brunoyam.consolemaster.dao.ArticleDbManipulator;
import com.brunoyam.consolemaster.dao.ArticleFileManipulator;
import com.brunoyam.consolemaster.dao.ArticleManipulator;
import com.brunoyam.consolemaster.service.CommandExecutorService;
import com.brunoyam.consolemaster.service.CreateService;
import com.brunoyam.consolemaster.ui.UserInterface;
import com.brunoyam.consolemaster.ui.console.ConsoleReader;
import com.brunoyam.consolemaster.ui.windows.FxApplication;

public class Config {

    private CommandExecutorService commandExecutor;
    private UserInterface userInterface;
    private CreateService createService;
    private ArticleManipulator articleManipulator;

    private static Config ourInstance = new Config();

    public static Config getInstance() {
        return ourInstance;
    }

    private Config() {
    }

    public void init(String[] args) {

        if(args.length == 0) {
            System.exit(1);
        }

        if(args[0].equals("window")) {
            userInterface = new FxApplication();
        } else {
            userInterface = new ConsoleReader();
        }

        if(args.length == 1
                || !args[1].equals("db")) {
            articleManipulator = new ArticleFileManipulator();
        } else {
            articleManipulator = new ArticleDbManipulator();
        }

        createService = CreateService.getInstance(articleManipulator);
        commandExecutor = CommandExecutorService.getInstance(createService);
    }

    public CommandExecutorService getCommandExecutor() {
        return commandExecutor;
    }

    public UserInterface getUserInterface() {
        return userInterface;
    }

    public CreateService getCreateService() {
        return createService;
    }

    public ArticleManipulator getArticleManipulator() {
        return articleManipulator;
    }
}
