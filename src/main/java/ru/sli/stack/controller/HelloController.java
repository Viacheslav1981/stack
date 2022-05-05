package ru.sli.stack.controller;

import org.springframework.web.bind.annotation.*;
import ru.sli.stack.dto.QuestionDto;
import ru.sli.stack.repository.Question;
import ru.sli.stack.service.CommentMapper;
import ru.sli.stack.service.QuestionMapper;
import ru.sli.stack.service.QuestionService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

//import ru.sli.stack.service.CommentService;

@RequestMapping("/questions")
@RestController
public class HelloController {
    private QuestionService questionService;
    // private CommentService commentService;
    private CommentMapper commentMapper;
    private QuestionMapper questionMapper;

    // private CommentMapper commentMapper = new CommentMapperImpl();

    public HelloController(QuestionService questionService, CommentMapper commentMapper, QuestionMapper questionMapper) {
        this.questionService = questionService;
        // this.commentService = commentService;
        this.commentMapper = commentMapper;
        this.questionMapper = questionMapper;
    }

//    @GetMapping("/{questionId}/comments")
//    public List<Comment> getCommentsByQuestionId(@PathVariable int questionId) {
//        return commentService.getCommentsByQuestionId(questionId);
//    }
//
//    @GetMapping("/{questionId}/comments/{commentId}")
//    public Comment getCommentById(@PathVariable int commentId) {
//        return commentService.getCommentById(commentId);
//    }
//
//    @DeleteMapping("/{questionId}/comments/{commentId}")
//    public void tableDelete(@PathVariable int commentId) {
//        commentService.tableDelete(commentId);
//    }
//
//    @PostMapping("{questionId}/comments")
//    public Comment tableInsert(@RequestBody Comment comment, @PathVariable int questionId) throws SQLException {
//        return commentService.tableInsert(questionId, comment);
//    }
//
//    @PutMapping("/comments")
//    public Comment tableUpdate(@RequestBody @Valid Comment comment) {
//        return commentService.tableUpdate(comment.getId(), comment.getComment());
//
//    }
//
//    @GetMapping("/test/{commentId}")
//    public CommentDto getTestDto(@PathVariable int commentId) {
//        return commentMapper.commentToDto(commentService.getCommentById(commentId));
//    }
//
//    @GetMapping("/test2/{questionId}")
//    public QuestionDto getQuestionDto(@PathVariable int questionId) {
//
//        return questionMapper.questionToDto(questionService.getById(questionId), commentService.getCommentsByQuestionId(questionId));
//    }
//
//
//    @GetMapping()
//    public List<QuestionDto> getQuestions() {
//        List<QuestionDto> questionDtoList = new ArrayList<>();
//        List<Question> questions = questionService.getQuestions();
//        for (int i = 0; i < questions.size(); i++) {
//            List<CommentDto> commentDtos = new ArrayList<>();
//            List<Comment> comments = commentService.getCommentsByQuestionId(questions.get(i).getId());
//            for (int j = 0; j < comments.size(); j++) {
//                CommentDto commentDto = new CommentDto(comments.get(j).getComment(), comments.get(j).getId(), comments.get(j).getQuestionId());
//                commentDtos.add(commentDto);
//            }
//
//            questionDtoList.add(new QuestionDto(questions.get(i).getId(), questions.get(i).getTitle(), questions.get(i).getDescription(), commentDtos));
//        }
//
//        return questionDtoList;
//    }
//
//    @GetMapping("/{id}")
//    public QuestionDto getById(@PathVariable int id) {
//        Question question = questionService.getById(id);
//        List<Comment> comments = commentService.getCommentsByQuestionId(id);
//        List<CommentDto> commentDtos = new ArrayList<>();
//        for (int i = 0; i < comments.size(); i++) {
//            CommentDto commentDto = new CommentDto(comments.get(i).getComment(), comments.get(i).getId(), comments.get(i).getQuestionId());
//            commentDtos.add(commentDto);
//        }
//
//        return new QuestionDto(id, question.getTitle(), question.getDescription(), commentDtos);
//    }

    @GetMapping
    public List<Question> findAll() {
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public QuestionDto findById(@PathVariable Integer id) {
        return questionService.getById(id)
                .map(questionMapper::toDto)
                .orElse(null);
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
