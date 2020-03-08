package com.brunoyam.consolemaster.dao;

import com.brunoyam.consolemaster.model.Article;

public interface ArticleManipulator {

    void create(Article article);

    void delete(Article article);

}
