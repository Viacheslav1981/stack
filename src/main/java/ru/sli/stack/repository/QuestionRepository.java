package ru.sli.stack.repository;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionRepository {

    public List<String> findAll() {

        List<String> list = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stackoverflow?user=postgres&password=voshod");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from questions");
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");

                list.add(title);
            }

        } catch (Exception e) {

        }

        return list;
    }
}
