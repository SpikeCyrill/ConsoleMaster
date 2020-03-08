package com.brunoyam.consolemaster.service;

import com.brunoyam.consolemaster.dao.ArticleManipulator;
import com.brunoyam.consolemaster.model.Article;
import com.brunoyam.consolemaster.model.Task;
import com.brunoyam.consolemaster.dao.ArticleFileManipulator;

import java.io.File;

public class CreateService implements TaskService {

    private static CreateService instance;

    private ArticleManipulator articleManipulator;

    public static CreateService getInstance(ArticleManipulator articleManipulator) {
        if (instance == null) {
            instance = new CreateService(articleManipulator);
        }

        return instance;
    }

    private CreateService(ArticleManipulator articleManipulator) {
        this.articleManipulator = articleManipulator;
    }

    public void doTask(Task task) {
        String articleName = task.getArguments()[0];

        Article newArticle = new Article(articleName);

        articleManipulator.create(newArticle);

    }

}
