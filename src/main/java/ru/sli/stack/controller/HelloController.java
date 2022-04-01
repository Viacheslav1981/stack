package ru.sli.stack.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sli.stack.repository.Questions;
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
    public List<Questions> testQuestion() {
        return questionService.retQuestions();
    }

    @GetMapping("/update")
    public void tableUpdate() {
        int id = 10;
        String title = "'пример для update7'";
        String description = "'update7 прошел как надо'";
        questionService.tableUpdate(id, title, description);

    }

    @GetMapping("/insert")
    public void tableInsert() {
        String title = "'пример для insert1'";
        String description = "'insert1 прошел успешно'";
        questionService.tableInsert(title, description);

    }

    @GetMapping("/delete")
    public void tableDelete() {
        int id = 17;
        questionService.tableDelete(id);

    }

}
