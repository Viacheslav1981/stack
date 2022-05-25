package ru.sli.stack.service;

import org.mapstruct.Mapper;
import ru.sli.stack.dto.CommentDto;
import ru.sli.stack.repository.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    CommentDto commentToDto(Comment comment);

    Comment toEntity(CommentDto commentDto);

}
