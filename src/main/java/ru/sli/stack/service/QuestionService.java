package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import ru.sli.stack.repository.Question;
import ru.sli.stack.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    public Question tableUpdate(int id, String title, String description) {
        Question question = new Question(id, title, description);
        return questionRepository.save(question);
    }

    public void tableDelete(int id) {
        questionRepository.deleteById(id);
    }

    public Optional<Question> getById(Integer id) {
        return questionRepository.findById(id);
    }

    public Question findById(Integer id) {
        return questionRepository.getById(id);
    }

    public Question tableInsert(String title, String description) {
        Question question = new Question(title, description);
        return questionRepository.save(question);
    }

}
