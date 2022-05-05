package ru.sli.stack.service;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.sli.stack.dto.CommentDto;
import ru.sli.stack.dto.QuestionDto;
import ru.sli.stack.repository.Comment;
import ru.sli.stack.repository.Question;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
public interface QuestionMapper {
    @Mapping(target = "comments", expression = "java(toCommentDto(com1))")
    QuestionDto questionToDto(Question question, List<Comment> com1);

    QuestionDto toDto(Question question);

    List<CommentDto> toCommentDto(List<Comment> comments);

}
