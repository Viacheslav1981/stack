package ru.sli.stack.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}

