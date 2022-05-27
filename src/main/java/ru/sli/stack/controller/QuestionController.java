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

//import ru.sli.stack.service.CommentService;

@Api(description = "работа с вопросами")
@RequestMapping("/questions")
@RestController
public class QuestionController {
    private QuestionService questionService;
    private CommentService commentService;
    private CommentMapper commentMapper;
    private QuestionMapper questionMapper;

    // private CommentMapper commentMapper = new CommentMapperImpl();

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
                //.filter(question -> question.getComments().size() > 0)
                .map(question -> questionMapper.toDto(question))
                .collect(Collectors.toList());
    }


    @ApiOperation("обновление вопроса")
    @PutMapping()
    public Question tableUpdate(@RequestBody Question question) {
        return questionService.tableUpdate(question.getId(), question.getTitle(), question.getDescription());
    }

    @ApiOperation("создание вопроса")
    @PostMapping()
    public QuestionDto tableInsert(@RequestBody @Valid QuestionDto questionDto) {
        Question question = questionMapper.toEntity(questionDto);
        question = questionService.create(question);
        return questionMapper.toDto(question);
    }

    @ApiOperation("удаление вопроса (с комментариями по нему)")
    @DeleteMapping("/{id}")
    public void tableDelete(@PathVariable Integer id) {
        questionService.tableDelete(id);
    }

    @ApiOperation("создание комментария по вопросу")
    @PostMapping("{questionId}/comments")
    public CommentDto tableInsert(@RequestBody CommentDto commentDto, @PathVariable int questionId) {
        Comment comment = commentMapper.toEntity(commentDto);
        comment = commentService.create(questionId, comment);
        return commentMapper.commentToDto(comment);
    }
//
//    @ApiOperation("создание комментария по вопросу")
//    @PostMapping("{questionId}/comments")
//    public Comment tableInsert(@RequestBody Comment comment, @PathVariable int questionId) {
//        return commentService.create(questionId, comment);
//    }


}
