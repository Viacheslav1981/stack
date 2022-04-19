package ru.sli.stack.controller;

import org.springframework.web.bind.annotation.*;
import ru.sli.stack.repository.Question;
import ru.sli.stack.service.QuestionService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RequestMapping("/questions")
@RestController
public class HelloController {
    private QuestionService questionService;

    public HelloController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping()
    public List<Question> testQuestion() {
        return questionService.retQuestions();
    }

    @GetMapping("/{id}")
    public Question getById(@PathVariable int id) {
        return questionService.getById(id);

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
