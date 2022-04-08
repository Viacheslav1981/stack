package ru.sli.stack.repository;

import org.springframework.stereotype.Component;

import java.sql.*;

import static java.sql.Statement.RETURN_GENERATED_KEYS;


@Component
public class DBworking {

    private Connection connection;
    int id = 0;

    public DBworking() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/stackoverflow?user=postgres&password=voshod");
    }

    public Statement getConnection() throws SQLException {
        Statement statement = connection.createStatement();
        return statement;
    }

    public void tableUpdate(String update) {
        try {
            getConnection().executeUpdate(update);
        } catch (Exception e) {

        }
    }

    public int tableInsert(String insert) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(insert, RETURN_GENERATED_KEYS);
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        generatedKeys.next();
        id = generatedKeys.getInt(1);
        System.out.println(id);

        return id;
    }

    public void tableDelete(String delete) {
        try {
            getConnection().executeUpdate(delete);
        } catch (Exception e) {

        }
    }

    public ResultSet tableSelect(String select) {
        ResultSet resultSet = null;
        try {
            resultSet = getConnection().executeQuery(select);
        } catch (Exception e) {

        }
        return resultSet;
    }


}
