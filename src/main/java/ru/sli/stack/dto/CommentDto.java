package ru.sli.stack.dto;

import io.swagger.annotations.ApiModelProperty;

public class CommentDto {
    @ApiModelProperty(value = "комментарий", example = "коммент 1")
    private String comment;
    private int id;
    private int questionId;

    public CommentDto(String comment, int id, int questionId) {
        this.comment = comment;
        this.id = id;
        this.questionId = questionId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
