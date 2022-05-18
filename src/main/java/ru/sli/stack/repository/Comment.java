package ru.sli.stack.repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity(name = "Comment")
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "поле не может быть пустым")
    private String comment;

    @ManyToOne
    private Question question;


    public Comment() {
    }

    Comment(String comment) {
        this.comment = comment;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
