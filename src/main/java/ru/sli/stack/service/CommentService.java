package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sli.stack.repository.Comment;
import ru.sli.stack.repository.CommentRepository;
import ru.sli.stack.repository.Question;

import java.time.ZonedDateTime;
import java.util.List;


@Service
public class CommentService {

    private CommentRepository commentRepository;
    private QuestionService questionService;

    public CommentService(CommentRepository commentRepository, QuestionService questionService) {
        this.commentRepository = commentRepository;
        this.questionService = questionService;
    }


//    public List<Comment> findByQuestionId(Integer id) {
//        List<Comment> comments = commentRepository.findAll();
//        Iterator<Comment> commentIterator = comments.iterator();
////        while (commentIterator.hasNext()) {
////            if (id != commentIterator.next().getQuestionId()) {
////                commentIterator.remove();
////            }
////        }
//        comments.removeIf(comment -> id != comment.getQuestionId());
//        return comments;
//    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Transactional
    public Comment create(int questionId, Comment comment) {

        Question question = questionService.findById(questionId);
        comment.setQuestion(question);
        comment.setCreatedAt(ZonedDateTime.now());
        question.getComments().add(comment);

        return commentRepository.save(comment);

    }


    /*
    public Comment getCommentById(int commentId) {
        return commentRepository.getCommentById(commentId);
    }

    public Comment tableUpdate(int id, String comment) {
        return commentRepository.tableUpdate(id, comment);

    }

    public void tableDelete(int commentId) {
        commentRepository.tableDelete(commentId);
    }

    public Comment tableInsert(int questionId, Comment comment) throws SQLException {
        return commentRepository.tableInsert(questionId, comment.getComment());

    }

     */
}
