package ru.sli.stack.dto;

import io.swagger.annotations.ApiModelProperty;

import java.time.ZonedDateTime;

public class CommentDto {
    @ApiModelProperty(value = "комментарий", example = "коммент 1")
    private String comment;
    private Integer id;
    private int questionId;

    private ZonedDateTime createdAt;

    public CommentDto() {
    }

    public CommentDto(String comment, Integer id, int questionId, ZonedDateTime createdAt) {
        this.comment = comment;
        this.id = id;
        this.questionId = questionId;
        this.createdAt = createdAt;
    }

    public CommentDto(String comment, Integer id, int questionId) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
}
