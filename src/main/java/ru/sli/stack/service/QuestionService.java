package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import ru.sli.stack.repository.QuestionRepository;
import ru.sli.stack.repository.Questions;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<List<String>> findAll() {
        return questionRepository.findAll();
    }

    public List<Questions> retQuestions() {
        return questionRepository.retQuestions();
    }

    public void tableUpdate(int id, String title, String description) {
        questionRepository.tableUpdate(id, title, description);
    }

    public void tableInsert(String title, String description) {
        questionRepository.tableInsert(title, description);
    }

    public void tableDelete(int id) {
        questionRepository.tableDelete(id);
    }
}
