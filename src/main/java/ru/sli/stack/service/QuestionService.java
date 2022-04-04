package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import ru.sli.stack.repository.Question;
import ru.sli.stack.repository.QuestionRepository;

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

    public List<Question> retQuestions() {
        return questionRepository.retQuestions();
    }

    public Question tableUpdate() {
        return questionRepository.tableUpdate();
    }

    public Question tableInsert() {
        return questionRepository.tableInsert();
    }

    public void tableDelete() {
        questionRepository.tableDelete();
    }

    public Question getById() {
        return questionRepository.getById();
    }


}
