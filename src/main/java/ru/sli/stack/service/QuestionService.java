package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sli.stack.repository.Question;
import ru.sli.stack.repository.QuestionRepository;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question questionUpdate(int id, String title, String description) {
        Question question = new Question(id, title, description);
        return questionRepository.save(question);
    }

    public void questionDelete(int id) {
        questionRepository.deleteById(id);
    }

    public Question getById(Integer id) {
        return questionRepository.getById(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }


    public Question findById(Integer id) {
        return questionRepository.findById(id).get();
        // return questionRepository.findById(id);
    }

    public Question tableInsert(String title, String description) {
        Question question = new Question(title, description);
        return questionRepository.save(question);
    }

    @Transactional
    public Question create(Question question) {
        question.setCreatedAt(ZonedDateTime.now());
        return questionRepository.save(question);
    }
}
