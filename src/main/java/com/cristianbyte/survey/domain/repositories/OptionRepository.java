package com.cristianbyte.survey.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristianbyte.survey.domain.entities.OptionQs;

public interface OptionRepository extends JpaRepository<OptionQs, Integer>{
    
}
