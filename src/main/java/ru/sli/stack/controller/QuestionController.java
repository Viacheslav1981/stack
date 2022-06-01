package ru.sli.stack.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.sli.stack.dto.CommentDto;
import ru.sli.stack.dto.QuestionDto;
import ru.sli.stack.repository.Comment;
import ru.sli.stack.repository.Question;
import ru.sli.stack.service.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Api(description = "работа с вопросами")
@RequestMapping("/questions")
@RestController
public class QuestionController {
    private QuestionService questionService;
    private CommentService commentService;
    private CommentMapper commentMapper;
    private QuestionMapper questionMapper;
    private QuestionPatcher questionPatcher;


    public QuestionController(QuestionService questionService, CommentService commentService, CommentMapper commentMapper, QuestionMapper questionMapper, QuestionPatcher questionPatcher) {
        this.questionService = questionService;
        this.commentService = commentService;
        this.commentMapper = commentMapper;
        this.questionMapper = questionMapper;
        this.questionPatcher = questionPatcher;
    }


    @ApiOperation("выдача вопроса")
    @GetMapping("/{id}")
    public QuestionDto findById(@PathVariable Integer id) {
        return questionMapper.toDto(questionService.findById(id));
    }

    @ApiOperation("выдача списка вопросов")
    @GetMapping
    public List<QuestionDto> findAll() {
        List<Question> questions = questionService.findAll();

        return questions.stream().sorted(Comparator.comparing(Question::getCreatedAt))
                .map(question -> questionMapper.toDto(question))
                .collect(Collectors.toList());
    }

    @ApiOperation("создание вопроса")
    @PostMapping()
    public QuestionDto createQuestion(@RequestBody @Valid QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        question = questionService.createQuestion(question);
        return questionMapper.toDto(question);
    }

    @ApiOperation("редактирование вопроса")
    @PutMapping("/{questionId}")
    public QuestionDto updateQuestion(@RequestBody @Valid QuestionDto questionDto, @PathVariable int questionId) throws NullPointerException {

        try {
            Question question = questionService.updateQuestion(questionDto, questionId);
            return questionMapper.toDto(question);

        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }

    }

    @ApiOperation("удаление вопроса (с комментариями по нему)")
    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Integer id) {
        questionService.deleteQuestion(id);
    }

    @ApiOperation("создание комментария по вопросу")
    @PostMapping("{questionId}/comments")
    public CommentDto createComment(@RequestBody CommentDto commentDto, @PathVariable int questionId) {
        Comment comment = commentMapper.toEntity(commentDto);
        comment = commentService.createComment(questionId, comment);
        return commentMapper.commentToDto(comment);
    }

    @ApiOperation("редактирование коммента")
    @PutMapping("/comments/{commentId}")
    public CommentDto updateComment(@RequestBody @Valid CommentDto commentDto, @PathVariable int commentId) {
        try {
            Comment comment = commentService.updateComment(commentDto, commentId);
            return commentMapper.commentToDto(comment);

        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }

    }


    @ApiOperation("удаление коммента")
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable int commentId) {
        commentService.commentDelete(commentId);
    }


}
