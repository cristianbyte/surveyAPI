package com.cristianbyte.survey.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.cristianbyte.survey.api.dto.request.QuestionRequest;
import com.cristianbyte.survey.api.dto.response.QuestionResponse;
import com.cristianbyte.survey.domain.entities.Question;

@Mapper(componentModel = "spring", uses = {OptionMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuestionMapper {
    @Mapping(target = "survey.id", source = "survey")
    @Mapping(target = "options", ignore = true)
    Question questionRequestToQuestion(QuestionRequest request);

    @Mapping(target = "survey", source = "survey.id")
    QuestionResponse questionToQuestionResponse(Question question);

    @Mapping(target = "survey", ignore = true)
    @Mapping(target = "options", ignore = true)
    void updateFromQuestionRequest(QuestionRequest request, @MappingTarget Question question);
}
