package com.cristianbyte.survey.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristianbyte.survey.domain.entities.Question;

public interface QuestionReposirory extends JpaRepository<Question, Integer>{
    
}
