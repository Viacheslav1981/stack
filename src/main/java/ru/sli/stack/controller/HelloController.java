package ru.sli.stack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sli.stack.service.QuestionService;

import java.util.List;

@RestController
public class HelloController {
    private QuestionService questionService;

    public HelloController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<String> testStr() {
        return questionService.findAll();
    }
}
