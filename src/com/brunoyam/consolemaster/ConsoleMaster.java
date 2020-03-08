package com.brunoyam.consolemaster;

import com.brunoyam.consolemaster.console.ConsoleReader;
import com.brunoyam.consolemaster.dao.ArticleDbManipulator;
import com.brunoyam.consolemaster.dao.ArticleFileManipulator;
import com.brunoyam.consolemaster.dao.ArticleManipulator;
import com.brunoyam.consolemaster.model.Article;
import com.brunoyam.consolemaster.service.CommandExecutorService;
import com.brunoyam.consolemaster.service.CreateService;

public class ConsoleMaster {

    public static void main(String[] args) {

        ArticleManipulator articleManipulator = null;

        if(args.length == 0
            || !args[0].equals("db")) {
            articleManipulator = new ArticleFileManipulator();
        } else {
            articleManipulator = new ArticleDbManipulator();
        }

        CreateService createService = CreateService.getInstance(articleManipulator);
        CommandExecutorService commandExecutor = CommandExecutorService.getInstance(createService);

        Thread thread = new Thread(commandExecutor);
        thread.start();

        ConsoleReader reader = new ConsoleReader(commandExecutor);
        reader.start();

    }

}
