package com.cristianbyte.survey.infrastructure.abstract_service;

import com.cristianbyte.survey.api.dto.request.QuestionRequest;
import com.cristianbyte.survey.api.dto.response.QuestionResponse;

public interface IQuestionService extends CrudAbstractService<QuestionRequest, QuestionResponse, Integer>{
    
}
