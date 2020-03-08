package com.brunoyam.consolemaster.dao;

import com.brunoyam.consolemaster.model.Article;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArticleDbManipulator implements ArticleManipulator {
    @Override
    public void create(Article article) {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:D:\\kolosov\\articles.s3db");

            String queryText = "INSERT INTO articles(name, text) VALUES(?, ?)";

            PreparedStatement ps = connection.prepareStatement(queryText);

            ps.setString(1, article.getName());
            ps.setString(2, article.getText());

            ps.executeUpdate();

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
    }

    @Override
    public void delete(Article article) {
        Connection connection = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:D:\\kolosov\\articles.s3db");

            String queryText = "DELETE FROM articles where name = ?";

            PreparedStatement ps = connection.prepareStatement(queryText);
            ps.setString(1, article.getName());

            ps.executeUpdate();


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
    }
}
