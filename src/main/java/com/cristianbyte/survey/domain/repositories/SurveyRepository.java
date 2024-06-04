package com.cristianbyte.survey.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristianbyte.survey.domain.entities.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Integer> {

} 
