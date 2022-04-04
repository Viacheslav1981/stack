package ru.sli.stack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sli.stack.repository.Question;
import ru.sli.stack.service.QuestionService;

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

    @GetMapping("/update")
    public Question tableUpdate() {
        return questionService.tableUpdate();

    }

    @GetMapping("/insert")
    public Question tableInsert() {
        return questionService.tableInsert();

    }

    @GetMapping("/delete")
    public void tableDelete() {
        questionService.tableDelete();
    }

    @GetMapping("/get")
    public Question getById() {
        return questionService.getById();

    }



}
