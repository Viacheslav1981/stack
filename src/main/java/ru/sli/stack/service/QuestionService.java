package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import ru.sli.stack.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<String> findAll() {
        return questionRepository.findAll();
    }
}
