package com.brunoyam.consolemaster.dao;

import com.brunoyam.consolemaster.model.Article;

import java.sql.*;

public class ArticleDbDataWR implements ArticleDataRW {

    @Override
    public Article read(String name) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:articles.s3db");
            String queryText = "Select * from articles where name = ?;";

            PreparedStatement ps = connection.prepareStatement(queryText);

            ps.setString(1, name);

            ResultSet resultSet = ps.executeQuery();

            if(resultSet.next()) {
                String articleName = resultSet.getString("name");
                Article article = new Article(articleName);

                String text = resultSet.getString("text");
                article.setText(text);

                return article;
            } else {
                return null;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    @Override
    public void write(Article article) {

    }
}
