//package ru.sli.stack.service;
//
//import org.springframework.stereotype.Service;
//import ru.sli.stack.repository.Comment;
//import ru.sli.stack.repository.CommentRepository;
//
//import java.sql.SQLException;
//import java.util.List;
//
//
//@Service
//public class CommentService {
//
//    private CommentRepository commentRepository;
//
//    public CommentService(CommentRepository commentRepository) {
//        this.commentRepository = commentRepository;
//    }
//
//    public List<Comment> getCommentsByQuestionId(int questionId) {
//        return commentRepository.getCommentsByQuestionId(questionId);
//    }
//
//    public Comment getCommentById(int commentId) {
//        return commentRepository.getCommentById(commentId);
//    }
//
//    public Comment tableUpdate(int id, String comment) {
//        return commentRepository.tableUpdate(id, comment);
//
//    }
//
//    public void tableDelete(int commentId) {
//        commentRepository.tableDelete(commentId);
//    }
//
//    public Comment tableInsert(int questionId, Comment comment) throws SQLException {
//        return commentRepository.tableInsert(questionId, comment.getComment());
//
//    }
//}
