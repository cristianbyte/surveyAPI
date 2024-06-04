package com.cristianbyte.survey.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.cristianbyte.survey.api.dto.request.SurveyRequest;
import com.cristianbyte.survey.api.dto.response.SurveyResponse;
import com.cristianbyte.survey.domain.entities.Survey;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SurveyMapper {

    @Mapping(target = "creator.id", source = "creator")
    Survey surveyReqeustToSurvey(SurveyRequest request);
    
    @Mapping(target = "creator", source = "creator.id")
    SurveyResponse surveyToSurveyResponse(Survey survey);
    
    @Mapping(target = "creator", ignore = true)
    void updateFromSurveyRequest(SurveyRequest request, @MappingTarget Survey survey);
}
