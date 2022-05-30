package ru.sli.stack.repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.List;

@Entity(name = "Question")
@Table(name = "questions", schema = "stack")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "поле не может быть пустым")
    private String title;
    @NotBlank(message = "поле не может быть пустым")
    private String description;

    @Column(name = "created_at")
    @Transient
    private ZonedDateTime createdAt;

    @Column(name = "modified_at")
    private ZonedDateTime modifiedAt;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Question() {
    }

    public Question(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Question(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setQuestion(this);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ZonedDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(ZonedDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
