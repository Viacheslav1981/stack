package ru.sli.stack.repository;

import javax.validation.constraints.NotBlank;

public class Comment {

    @NotBlank(message = "поле не может быть пустым")
    private String comment;
    private int id;
    private int questionId;


    public Comment(int questionId, String comment) {
        this.comment = comment;
        this.questionId = questionId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
