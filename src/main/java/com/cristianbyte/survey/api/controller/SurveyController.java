package com.cristianbyte.survey.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cristianbyte.survey.api.dto.request.SurveyRequest;
import com.cristianbyte.survey.api.dto.response.SurveyResponse;
import com.cristianbyte.survey.infrastructure.abstract_service.ISurveyService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping(path = "/surveys")
@AllArgsConstructor
@Tag(name = "Survey")
public class SurveyController {
    @Autowired
    private final ISurveyService surveyService;

    @GetMapping
    public ResponseEntity<Page<SurveyResponse>> getAll(        
        @RequestParam(defaultValue = "1") int page, 
        @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.surveyService.getAll(page, size));
    }
    
    @PostMapping
    public ResponseEntity<SurveyResponse> postMethodName(@Validated @RequestBody SurveyRequest request) {
        return ResponseEntity.ok(this.surveyService.create(request));
    }


    
}
