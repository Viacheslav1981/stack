package ru.sli.stack.repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "поле не может быть пустым")
    private String comment;

    @ManyToOne
    private Question question;

    // private Integer questionid;

    public Comment() {
    }

    Comment(String comment) {
        this.comment = comment;
        //  this.questionid = questionId;
    }
//    public int getQuestionId() {
//        return questionid;
//    }

//    public void setQuestionId(int questionId) {
//        this.questionid = questionId;
//    }

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
