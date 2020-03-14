package com.brunoyam.consolemaster.dao;

import com.brunoyam.consolemaster.model.Article;

public interface ArticleDataRW {

    public Article read(String name);
    public void write(Article article);

}
