package com.cristianbyte.survey.infrastructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cristianbyte.survey.api.dto.request.OptionG;
import com.cristianbyte.survey.api.dto.request.QuestionRequest;
import com.cristianbyte.survey.api.dto.response.QuestionResponse;
import com.cristianbyte.survey.api.mapper.QuestionMapper;
import com.cristianbyte.survey.domain.entities.Question;
import com.cristianbyte.survey.domain.repositories.QuestionReposirory;
import com.cristianbyte.survey.infrastructure.abstract_service.IOptionService;
import com.cristianbyte.survey.infrastructure.abstract_service.IQuestionService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class QuestionService implements IQuestionService{


    @Autowired
    private final QuestionReposirory questionReposirory;
    
    @Autowired
    private final QuestionMapper questionMapper;

    @Autowired
    private final IOptionService optionService;

    @Override
    public Page<QuestionResponse> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public QuestionResponse getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public QuestionResponse create(QuestionRequest request) {
        Question newQuestion = questionMapper.questionRequestToQuestion(request);
        QuestionResponse questionResponse = questionMapper.questionToQuestionResponse(this.questionReposirory.save(newQuestion));
        List<OptionG> optionsList = request.getOptions();
        optionsList.forEach(option -> option.setQuestion(questionResponse.getId()));
        this.optionService.saveAll(optionsList);
        return questionResponse;
    }

    @Override
    public QuestionResponse update(Integer id, QuestionRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}