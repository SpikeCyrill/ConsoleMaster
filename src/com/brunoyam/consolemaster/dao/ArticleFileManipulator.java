package com.brunoyam.consolemaster.dao;

import com.brunoyam.consolemaster.model.Article;

import java.io.File;
import java.io.IOException;

public class ArticleFileManipulator implements ArticleManipulator {

    private static String ARTICLE_EXTENSION = ".txt";

    public void create(Article article) {

        File file = articleToFile(article);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Article article) {

        File file = articleToFile(article);

        if(file.exists()) {
            file.delete();
        }
    }

    private File articleToFile(Article article) {
        File file = new File(article.getName() + ARTICLE_EXTENSION);
        return file;
    }

}
