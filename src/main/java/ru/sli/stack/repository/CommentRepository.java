package ru.sli.stack.repository;


import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommentRepository {
    int id = 0;
    private DBworking dBworking;
    private Comment comment;

    public CommentRepository(DBworking dBworking) {
        this.dBworking = dBworking;
    }

    public Comment getCommentById(int commentId) {
        try {
            String select = "select * from comments where id= " + commentId;
            ResultSet resultSet = dBworking.tableSelect(select);

            while (resultSet.next()) {
                int questionIdin = resultSet.getInt("questionid");
                String commentIn = resultSet.getString("comment");
                comment = new Comment(questionIdin, commentIn);
            }

        } catch (Exception e) {

        }
        return comment;
    }

    public List<Comment> getCommentsByQuestionId(int questionId) {

        List<Comment> commentList = new ArrayList<>();

        try {
            String select = "select * from comments where questionid= " + questionId;
            ResultSet resultSet = dBworking.tableSelect(select);

            while (resultSet.next()) {
                String commentIn = resultSet.getString("comment");
                comment = new Comment(questionId, commentIn);
                commentList.add(comment);
            }

        } catch (Exception e) {

        }
        return commentList;
    }

    public Comment tableInsert(int questionId, String comment) throws SQLException {
        String insert = "insert into comments (comment, createdat, questionid) values ('" + comment + "' , CURRENT_TIMESTAMP , '" + questionId + "')";
        id = dBworking.tableInsert(insert);
        return getCommentById(id);
    }

    public Comment tableUpdate(int id, String comment) {

        try {
            String update = "update comments set comment = '" + comment + "', modifiedat = CURRENT_TIMESTAMP where id = " + id;
            dBworking.tableUpdate(update);

        } catch (Exception e) {

        }
        return getCommentById(id);
    }

    public void tableDelete(int id) {
        try {
            String delete = "delete from comments where id = " + id;
            dBworking.tableDelete(delete);
        } catch (Exception e) {

        }
    }

}

