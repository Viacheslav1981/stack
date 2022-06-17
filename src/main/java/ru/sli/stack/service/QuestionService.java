package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sli.stack.dto.QuestionDto;
import ru.sli.stack.repository.Question;
import ru.sli.stack.repository.QuestionRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private QuestionPatcher questionPatcher;
    private QuestionMapper questionMapper;

    public QuestionService(QuestionRepository questionRepository, QuestionPatcher questionPatcher, QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionPatcher = questionPatcher;
        this.questionMapper = questionMapper;
    }

    @Transactional
    public Question updateQuestion(QuestionDto questionDto, int questionId) {
        Question question = findById(questionId);
        question.setModifiedAt(ZonedDateTime.now());
        return questionRepository.save(questionPatcher.updateQuestionFromDTO(questionDto, question));

    }

    public void deleteQuestion(int id) {
        questionRepository.deleteById(id);
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findById(Integer id) throws NoSuchElementException {
        try {
            return questionRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            //  System.out.println("test");
            return null;
        }
    }

    @Transactional
    public Question createQuestion(Question question) {
        question.setCreatedAt(ZonedDateTime.now());
        return questionRepository.save(question);
    }
}
