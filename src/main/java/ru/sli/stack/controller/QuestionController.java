package ru.sli.stack.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import ru.sli.stack.dto.CommentDto;
import ru.sli.stack.dto.QuestionDto;
import ru.sli.stack.repository.Comment;
import ru.sli.stack.repository.Question;
import ru.sli.stack.service.CommentMapper;
import ru.sli.stack.service.CommentService;
import ru.sli.stack.service.QuestionMapper;
import ru.sli.stack.service.QuestionService;

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


    public QuestionController(QuestionService questionService, CommentService commentService, CommentMapper commentMapper, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.commentService = commentService;
        this.commentMapper = commentMapper;
        this.questionMapper = questionMapper;
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

    @ApiOperation("редактирование вопроса")
    @PutMapping()
    public QuestionDto updateQuestion(@RequestBody @Valid QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        questionService.updateQuestion(question);
        return questionMapper.toDto(question);
    }

    @ApiOperation("создание вопроса")
    @PostMapping()
    public QuestionDto createQuestion(@RequestBody @Valid QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        question = questionService.createQuestion(question);
        return questionMapper.toDto(question);
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
    @PutMapping("/comments")
    public CommentDto updateComment(@RequestBody @Valid CommentDto commentDto) {
        Comment comment = commentMapper.toEntity(commentDto);
        commentService.updateComment(comment);
        return commentMapper.commentToDto(comment);
    }

    @ApiOperation("удаление коммента")
    @DeleteMapping("/comments/{commentId}")
    public void deleteComment(@PathVariable int commentId) {
        commentService.commentDelete(commentId);
    }


}
