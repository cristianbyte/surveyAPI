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

import com.cristianbyte.survey.api.dto.request.QuestionRequest;
import com.cristianbyte.survey.api.dto.response.QuestionResponse;
import com.cristianbyte.survey.infrastructure.abstract_service.IQuestionService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/questions")
@AllArgsConstructor
@Tag(name = "Questions")
public class QuestionController {
    
    @Autowired
    private final IQuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionResponse> createQuestion(@Validated @RequestBody QuestionRequest qeustionRequest){
        return ResponseEntity.ok(this.questionService.create(qeustionRequest));
    }

    @GetMapping
    public ResponseEntity<Page<QuestionResponse>> getAll(        
        @RequestParam(defaultValue = "1") int page, 
        @RequestParam(defaultValue = "10") int size) {
            return ResponseEntity.ok(this.questionService.getAll(page, size));
        }


}
