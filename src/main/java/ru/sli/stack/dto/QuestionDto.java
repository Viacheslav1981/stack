package ru.sli.stack.dto;

import io.swagger.annotations.ApiModelProperty;

import java.time.ZonedDateTime;
import java.util.List;

public class QuestionDto {

    private Integer id;
    @ApiModelProperty(value = "заголовок вопроса", example = "вопрос 1")
    private String title;
    @ApiModelProperty(value = "полный текс вопроса", example = "текст вопрсоа 1")
    private String description;

    @ApiModelProperty(value = "дата создания вопроса")
    private ZonedDateTime createdAt;

    @ApiModelProperty(value = "дата редактирования вопроса")
    private ZonedDateTime modifiedAt;

    private List<CommentDto> comments;

    public QuestionDto() {
    }

    public QuestionDto(int id, String title, String description, ZonedDateTime createdAt, List<CommentDto> comments) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.createdAt = createdAt;
        this.comments = comments;
    }


    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(ZonedDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
