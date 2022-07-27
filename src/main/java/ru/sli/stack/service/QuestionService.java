package ru.sli.stack.service;

import org.springframework.security.core.context.SecurityContextHolder;
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


    public QuestionService(QuestionRepository questionRepository,
                           QuestionPatcher questionPatcher,
                           QuestionMapper questionMapper) {
        this.questionRepository = questionRepository;
        this.questionPatcher = questionPatcher;
        this.questionMapper = questionMapper;
    }

    @Transactional
    public Question updateQuestion(QuestionDto questionDto, int questionId) {
        Question question = findById(questionId);
        if (findById(questionId).getCreatedBy().equals(getUsername())
                || SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_ADMIN")) {
            question.setModifiedAt(ZonedDateTime.now());
            question.setModifiedBy(getUsername());
            question = questionRepository.save(questionPatcher.updateQuestionFromDTO(questionDto, question));
        }

        return question;

    }

    public void deleteQuestion(int id) {

//        List<GrantedAuthority> grantedAuthorityList = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//        System.out.println(grantedAuthorityList.get(0).toString().equals("ROLE_ADMIN"));

        //  System.out.println(findById(id).getCreatedBy());
        //  System.out.println(getUsername());

        //  System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_ADMIN"));
        // System.out.println();
        if (findById(id).getCreatedBy().equals(getUsername())
                || SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().contains("ROLE_ADMIN")) {
            questionRepository.deleteById(id);
        }

    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Question findById(Integer id) throws NoSuchElementException {
        try {
            return questionRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }



    @Transactional
    public Question createQuestion(Question question) {
        question.setCreatedAt(ZonedDateTime.now());
        question.setCreatedBy(getUsername());
        return questionRepository.save(question);
    }
}
