package ru.sli.stack.repository;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionRepository {
    private DBworking dBworking;
    int id = 27;
    String title = "пример вставки строки";
    String description = "проверка возврата вставленной строки на front";
    String update = "update questions set title = 'проверка апдейта1', description = 'проходим апдейт номер 1', modifiedat = CURRENT_TIMESTAMP where id = " + id;
    String insert = "insert into questions (title, description, createdat) values ('пример вставки строки99', 'вставка99 прошла' , CURRENT_TIMESTAMP)";
    String delete = "delete from questions where id = " + id;
    String select = "select * from questions where id= " + id;
    String selectAll = "select * from questions";
    private Question question;

    public QuestionRepository(DBworking dBworking) {
        this.dBworking = dBworking;
    }

    public Question tableUpdate() {
        try {
            dBworking.tableUpdate(update);
            ResultSet resultSet = dBworking.getConnection().executeQuery("select * from questions where id=" + id);

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                question = new Question(title, description);

            }

        } catch (Exception e) {

        }
        return question;
    }

    public Question tableInsert() {
        try {
            dBworking.tableInsert(insert);
            ResultSet resultSet = dBworking.getConnection().executeQuery("select * from questions where title='пример вставки строки123'");

            while (resultSet.next()) {
                String titleIn = resultSet.getString("title");
                String descriptionIn = resultSet.getString("description");
                question = new Question(titleIn, descriptionIn);

            }

        } catch (Exception e) {

        }
        return question;
    }

    public void tableDelete() {
        try {
            dBworking.tableDelete(delete);
        } catch (Exception e) {

        }
    }

    public Question getById() {
        try {
            ResultSet resultSet = dBworking.tableSelect(select);

            while (resultSet.next()) {
                String titleIn = resultSet.getString("title");
                String descriptionIn = resultSet.getString("description");
                question = new Question(titleIn, descriptionIn);
            }

        } catch (Exception e) {

        }
        return question;
    }

    public List<List<String>> findAll() {
        List<List<String>> listAll = new ArrayList<>();
        try {
            ResultSet resultSet = dBworking.tableSelect(selectAll);

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

    public List<Question> retQuestions() {

        List<Question> questionList = new ArrayList<>();

        try {
            ResultSet resultSet = dBworking.tableSelect(selectAll);

            while (resultSet.next()) {

                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Question question = new Question(title, description);
                questionList.add(question);

            }

        } catch (Exception e) {

        }

        return questionList;
    }


}
