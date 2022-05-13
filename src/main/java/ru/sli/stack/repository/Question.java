package ru.sli.stack.repository;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "поле не может быть пустым")
    private String title;
    @NotBlank(message = "поле не может быть пустым")
    private String description;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<Comment> comments;

    public Question() {
    }

    /*
    public Question(Integer id, @NotBlank(message = "поле не может быть пустым") String title, @NotBlank(message = "поле не может быть пустым") String description, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;


     */

    public Question(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Question(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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
