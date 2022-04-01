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
    private DBworking dBworking;

    public QuestionRepository(DBworking dBworking) {
        this.dBworking = dBworking;
    }

    public void tableUpdate(int id, String title, String description) {
        try {
            dBworking.getConnection().executeUpdate("update questions set title = " + title + ", description = " + description + ", modifiedat = CURRENT_TIMESTAMP where id = " + id);
        } catch (Exception e) {

        }
    }

    public List<Questions> retQuestions() {

        List<Questions> questionsList = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stackoverflow?user=postgres&password=voshod");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from questions");

            while (resultSet.next()) {

                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Questions questions = new Questions(title, description);
                questionsList.add(questions);

            }

        } catch (Exception e) {

        }

        return questionsList;
    }

    public List<List<String>> findAll() {

        // List<String> listAll = new ArrayList<>();
        List<List<String>> listAll = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stackoverflow?user=postgres&password=voshod");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from questions");

            while (resultSet.next()) {

                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                List<String> listRow = new ArrayList<>();

                listRow.add(title);
                listRow.add(description);
                listAll.add(listRow);

            }

        } catch (Exception e) {

        }

        return listAll;
    }
}
