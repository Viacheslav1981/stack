package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sli.stack.dto.CommentDto;
import ru.sli.stack.repository.Comment;
import ru.sli.stack.repository.CommentRepository;
import ru.sli.stack.repository.Question;

import java.time.ZonedDateTime;
import java.util.NoSuchElementException;

@Service
public class CommentService {

    private CommentRepository commentRepository;
    private QuestionService questionService;
    private CommentPatcher commentPatcher;

    public CommentService(CommentRepository commentRepository, QuestionService questionService, CommentPatcher commentPatcher) {
        this.commentRepository = commentRepository;
        this.questionService = questionService;
        this.commentPatcher = commentPatcher;
    }

    @Transactional
    public Comment updateComment(CommentDto commentDto, int commentId) {
        Comment comment = findById(commentId);
        comment.setModifiedAt(ZonedDateTime.now());
        return commentRepository.save(commentPatcher.updateCommentFromDTO(commentDto, comment));
    }

    public Comment findById(Integer id) throws NoSuchElementException {
        try {
            return commentRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }
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
