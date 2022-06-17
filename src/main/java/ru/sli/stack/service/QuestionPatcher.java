package ru.sli.stack.service;


import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import ru.sli.stack.dto.QuestionDto;
import ru.sli.stack.repository.Question;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface QuestionPatcher {
    Question updateQuestionFromDTO(QuestionDto questionDto, @MappingTarget Question question);

}
