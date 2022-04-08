package ru.sli.stack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sli.stack.repository.Question;
import ru.sli.stack.service.QuestionService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class HelloController {
    private QuestionService questionService;

    public HelloController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<List<String>> testStr() {
        return questionService.findAll();
    }

    @GetMapping("/questions")
    public List<Question> testQuestion() {
        return questionService.retQuestions();
    }

    @GetMapping("/update/id={id}&title={title}&description={description}")
    public Question tableUpdate(@PathVariable int id, @PathVariable String title, @PathVariable String description) {
        return questionService.tableUpdate(id, title, description);

    }

    @GetMapping("/insert")
    public Question tableInsert(@RequestParam String title, @RequestParam String description) throws SQLException {
        return questionService.tableInsert(title, description);
    }

    @GetMapping("/delete/id={id}")
    public void tableDelete(@PathVariable int id) {
        questionService.tableDelete(id);
    }

    @GetMapping("/get/id={id}")
    public Question getById(@PathVariable int id) {
        return questionService.getById(id);

    }

}
