package com.cristianbyte.survey.infrastructure.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cristianbyte.survey.api.dto.request.SurveyRequest;
import com.cristianbyte.survey.api.dto.response.SurveyResponse;
import com.cristianbyte.survey.api.mapper.SurveyMapper;
import com.cristianbyte.survey.domain.entities.Survey;
import com.cristianbyte.survey.domain.entities.User;
import com.cristianbyte.survey.domain.repositories.SurveyRepository;
import com.cristianbyte.survey.domain.repositories.UserRepository;
import com.cristianbyte.survey.infrastructure.abstract_service.ISurveyService;
import com.cristianbyte.survey.infrastructure.helper.EmailHelper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class SurveyService implements ISurveyService{

    @Autowired
    private final SurveyRepository surveyRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final SurveyMapper surveyMapper;

    @Autowired
    private final EmailHelper mailHelper;

    @Override
    public Page<SurveyResponse> getAll(int page, int size) {
        if (page <0) page = 0;
        PageRequest pagination = PageRequest.of(page -1, size);
        return this.surveyRepository.findAll(pagination).map(surveyMapper::surveyToSurveyResponse);
    }

    @Override
    public SurveyResponse getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public SurveyResponse create(SurveyRequest request) {
        Survey newSurvey = surveyMapper.surveyReqeustToSurvey(request);
        // set creation date right now
        newSurvey.setCreationDate(LocalDate.now());
        User creator = this.userRepository.findById(request.getCreator()).orElseThrow();
        this.mailHelper.sendMail(creator.getEmail(), creator.getName(), newSurvey.getTitle());

        return surveyMapper.surveyToSurveyResponse(this.surveyRepository.save(newSurvey));
    }

    @Override
    public SurveyResponse update(Integer id, SurveyRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
