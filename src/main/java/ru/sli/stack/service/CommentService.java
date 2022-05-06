package ru.sli.stack.service;

import org.springframework.stereotype.Service;
import ru.sli.stack.repository.Comment;
import ru.sli.stack.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;


@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }


    public List<Comment> findByQuestionId(Integer id) {
        List<Comment> comments = commentRepository.findAll();
        List<Comment> returnComments = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
            if (id == comments.get(i).getQuestionId()) {
                returnComments.add(comments.get(i));
            }

        }
        return returnComments;
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    /*
    public List<Comment> getCommentsByQuestionId(int questionId) {
        List<Comment> comments = commentRepository.findAll();
        List<Comment> returnComments = new ArrayList<>();
        for (int i = 0; i < comments.size(); i++) {
           if (comments.get(i).getQuestionId() == questionId) {
               returnComments.add(comments.get(i));
           }
        }
        return returnComments;

      //  return commentRepository.getCommentsByQuestionId(questionId);
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
