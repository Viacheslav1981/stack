package ru.sli.stack.repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Entity(name = "Comment")
@Table(name = "comments", schema = "stack")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "поле не может быть пустым")
    private String comment;

    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "question_id")
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

    public Comment(String comment) {
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
