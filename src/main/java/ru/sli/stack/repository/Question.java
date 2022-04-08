package ru.sli.stack.repository;

import javax.validation.constraints.NotBlank;

public class Question {

    @NotBlank(message = "поле не может быть пустым")
    public String title;
    public String description;
    public int id;

    public Question(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
