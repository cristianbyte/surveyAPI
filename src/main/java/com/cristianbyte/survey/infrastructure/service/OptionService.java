package com.cristianbyte.survey.infrastructure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.cristianbyte.survey.api.dto.request.OptionG;
import com.cristianbyte.survey.api.mapper.OptionMapper;
import com.cristianbyte.survey.domain.entities.OptionQs;
import com.cristianbyte.survey.domain.repositories.OptionRepository;
import com.cristianbyte.survey.infrastructure.abstract_service.IOptionService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;


@Service
@Transactional
@AllArgsConstructor
public class OptionService implements IOptionService {

    @Autowired
    private final OptionRepository optionRepository;

    @Autowired
    private final OptionMapper optionMapper;

    @Override
    public Page<OptionG> getAll(int page, int size) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public OptionG getById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public OptionG create(OptionG request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public OptionG update(Integer id, OptionG request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<OptionG> saveAll(List<OptionG> requestList) {
        List<OptionQs> OptionList;
        if (requestList == null || requestList.isEmpty()) {
            throw new IllegalArgumentException("The request list is empty");
        }else{
            OptionList = requestList.stream().map(Option -> optionMapper.optiongToOptionqs(Option)).toList();
        }
        return this.optionRepository.saveAll(OptionList).stream().map(option -> optionMapper.optionqsToOptionqG(option)).toList();
    }
}
    
