package ru.sli.stack.repository;

import javax.validation.constraints.NotBlank;

public class Question {

    @NotBlank(message = "поле не может быть пустым")
    private String title;
    @NotBlank(message = "поле не может быть пустым")
    private String description;
    private int id;

    public Question(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Question(String title, String description) {
        this.title = title;
        this.description = description;
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
}
