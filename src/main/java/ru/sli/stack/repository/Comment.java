package ru.sli.stack.repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Entity(name = "Comment")
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "поле не может быть пустым")
    private String comment;

    @Column(name = "createdat")
    private ZonedDateTime createdAt;


    @ManyToOne
    private Question question;


    public Comment() {
    }

    public Comment(String comment, ZonedDateTime createdAt) {
        this.comment = comment;
        this.createdAt = createdAt;
    }

    public Comment(String comment, Question question) {
        this.comment = comment;
        this.question = question;
    }


    public ZonedDateTime getCreatedAt() {
        return createdAt;
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

    public void setCreatedAt(ZonedDateTime now) {

    }
}
