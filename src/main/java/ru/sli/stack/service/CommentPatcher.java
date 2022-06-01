package ru.sli.stack.service;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.sli.stack.dto.CommentDto;
import ru.sli.stack.repository.Comment;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CommentPatcher {
    Comment updateCommentFromDTO(CommentDto commentDto, @MappingTarget Comment comment);
}
