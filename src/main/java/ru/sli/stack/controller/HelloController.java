package ru.sli.stack.controller;

import org.springframework.web.bind.annotation.*;
import ru.sli.stack.dto.QuestionDto;
import ru.sli.stack.repository.Comment;
import ru.sli.stack.repository.Question;
import ru.sli.stack.service.CommentService;
import ru.sli.stack.service.QuestionService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/questions")
@RestController
public class HelloController {
    private QuestionService questionService;
    private CommentService commentService;

    public HelloController(QuestionService questionService, CommentService commentService) {
        this.questionService = questionService;
        this.commentService = commentService;
    }

    @GetMapping("/{questionId}/comments")
    public List<Comment> getCommentsByQuestionId(@PathVariable int questionId) {
        return commentService.getCommentsByQuestionId(questionId);
    }

    @GetMapping("/{questionId}/comments/{commentId}")
    public Comment getCommentById(@PathVariable int commentId) {
        return commentService.getCommentById(commentId);
    }

    @DeleteMapping("/{questionId}/comments/{commentId}")
    public void tableDelete(@PathVariable int commentId) {
        commentService.tableDelete(commentId);
    }

    @PostMapping("{questionId}/comments")
    public Comment tableInsert(@RequestBody Comment comment, @PathVariable int questionId) throws SQLException {
        return commentService.tableInsert(questionId, comment);
    }

    @PutMapping("/comments")
    public Comment tableUpdate(@RequestBody @Valid Comment comment) {
        return commentService.tableUpdate(comment.getId(), comment.getComment());

    }

    /*
    @GetMapping()
    public List<Question> getQuestion() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable int id) {
        return questionService.getById(id);

    }

     */

    @GetMapping()
    public List<QuestionDto> getQuestion() {
        List<QuestionDto> questionDtoList = new ArrayList<>();
        List<Question> questions = questionService.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            List<Comment> comments = commentService.getCommentsByQuestionId(questions.get(i).getId());
            questionDtoList.add(new QuestionDto(questions.get(i).getId(), questions.get(i).getTitle(), questions.get(i).getDescription(), comments));
        }

        return questionDtoList;
    }

    @GetMapping("/{id}")
    public QuestionDto getById(@PathVariable int id) {
        Question question = questionService.getById(id);
        List<Comment> comments = commentService.getCommentsByQuestionId(id);
        return new QuestionDto(id, question.getTitle(), question.getDescription(), comments);
    }

    @PutMapping()
    public Question tableUpdate(@RequestBody Question question) {
        return questionService.tableUpdate(question.getId(), question.getTitle(), question.getDescription());
    }

    @PostMapping()
    public Question tableInsert(@RequestBody @Valid Question question) throws SQLException {
        return questionService.tableInsert(question.getTitle(), question.getDescription());
    }

    @DeleteMapping("/{id}")
    public void tableDelete(@PathVariable Integer id) {
        questionService.tableDelete(id);
    }

}
