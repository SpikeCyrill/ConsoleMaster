package com.brunoyam.consolemaster.service;

import com.brunoyam.consolemaster.ui.console.ConsoleWriter;
import com.brunoyam.consolemaster.dao.ArticleDataRW;
import com.brunoyam.consolemaster.dao.ArticleDbDataWR;
import com.brunoyam.consolemaster.model.Article;
import com.brunoyam.consolemaster.model.Task;

public class ShowService implements TaskService {
    @Override
    public void doTask(Task task) {

        String articleName = task.getArguments()[0];

        ArticleDataRW articleDataRW = new ArticleDbDataWR();

        Article article = articleDataRW.read(articleName);

        ConsoleWriter consoleWriter = new ConsoleWriter();

        consoleWriter.println(article.getText());

    }
}
