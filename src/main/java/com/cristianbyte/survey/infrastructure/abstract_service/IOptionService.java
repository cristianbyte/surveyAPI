package com.cristianbyte.survey.infrastructure.abstract_service;

import java.util.List;

import com.cristianbyte.survey.api.dto.request.OptionG;

public interface IOptionService extends CrudAbstractService<OptionG, OptionG, Integer>{
    List<OptionG> saveAll(List<OptionG> requestList);
}
