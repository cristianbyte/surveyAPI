package com.cristianbyte.survey.infrastructure.abstract_service;

import com.cristianbyte.survey.api.dto.request.SurveyRequest;
import com.cristianbyte.survey.api.dto.response.SurveyResponse;

public interface ISurveyService extends CrudAbstractService<SurveyRequest, SurveyResponse, Integer>{
    
}
