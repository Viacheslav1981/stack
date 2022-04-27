package ru.sli.stack.dto;

import ru.sli.stack.repository.Comment;

import java.util.List;

public class QuestionDto {

    private int id;
    private String title;
    private String description;

    private List<Comment> comments;

    public QuestionDto(int id, String title, String description, List<Comment> comments) {
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
