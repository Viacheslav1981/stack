package ru.sli.stack.dto;

import java.util.List;

public class QuestionDto {

    private int id;
    private String title;
    private String description;

    private List<CommentDto> comments;

    public QuestionDto(int id, String title, String description, List<CommentDto> comments) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.comments = comments;
    }

    public QuestionDto(int id, String title, String description) {
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public QuestionDto(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public QuestionDto(int id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }
}
