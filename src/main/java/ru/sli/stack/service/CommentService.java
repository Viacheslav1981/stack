package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sli.stack.repository.Comment;
import ru.sli.stack.repository.CommentRepository;
import ru.sli.stack.repository.Question;

import java.time.ZonedDateTime;


@Service
public class CommentService {

    private CommentRepository commentRepository;
    private QuestionService questionService;

    public CommentService(CommentRepository commentRepository, QuestionService questionService) {
        this.commentRepository = commentRepository;
        this.questionService = questionService;
    }

    @Transactional
    public Comment updateComment(Comment comment) {
        comment.setModifiedAt(ZonedDateTime.now());
        return commentRepository.save(comment);
    }

    @Transactional
    public Comment createComment(int questionId, Comment comment) {

        Question question = questionService.findById(questionId);
        comment.setQuestion(question);
        comment.setCreatedAt(ZonedDateTime.now());
        question.getComments().add(comment);

        return commentRepository.save(comment);

    }

    public void commentDelete(int commentId) {
        commentRepository.deleteById(commentId);
    }


}
