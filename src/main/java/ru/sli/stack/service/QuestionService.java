package ru.sli.stack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sli.stack.repository.Question;
import ru.sli.stack.repository.QuestionRepository;

import java.sql.SQLException;
import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public void setQuestionRepository(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

//    public QuestionService(QuestionRepository questionRepository) {
//        this.questionRepository = questionRepository;
//    }

    public List<List<String>> findAll() {
        return questionRepository.findAll();
    }

    public List<Question> retQuestions() {
        return questionRepository.retQuestions();
    }

    public Question tableUpdate(int id, String title, String description) {
        return questionRepository.tableUpdate(id, title, description);
    }

    public void tableDelete(int id) {
        questionRepository.tableDelete(id);
    }

    public Question getById(int id) {
        return questionRepository.getById(id);
    }


    public Question tableInsert(String title, String description) throws SQLException {
        return questionRepository.tableInsert(title, description);
    }

}
