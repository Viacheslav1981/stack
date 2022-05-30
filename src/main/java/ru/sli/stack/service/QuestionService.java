package ru.sli.stack.service;

import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sli.stack.repository.Question;
import ru.sli.stack.repository.QuestionRepository;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class QuestionService {

    private Session session;

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional
    public Question updateQuestion(Question question) {
        question.setModifiedAt(ZonedDateTime.now());
        return questionRepository.save(question);
    }

    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findById(Integer id) {
        return questionRepository.findById(id).get();
    }

    @Transactional
    public Question createQuestion(Question question) {
        question.setCreatedAt(ZonedDateTime.now());
        return questionRepository.save(question);
    }
}
