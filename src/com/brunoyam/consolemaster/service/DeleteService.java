package com.brunoyam.consolemaster.service;

import com.brunoyam.consolemaster.model.Article;
import com.brunoyam.consolemaster.model.Task;
import com.brunoyam.consolemaster.dao.ArticleFileManipulator;

import java.io.File;

public class DeleteService implements TaskService {

    public void doTask(Task task) {
        ArticleFileManipulator articleFileManipulator = new ArticleFileManipulator();

        String articleName = task.getArguments()[0];

        Article newArticle = new Article(articleName);

        articleFileManipulator.delete(newArticle);
    }

}
