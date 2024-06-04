package com.cristianbyte.survey.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.cristianbyte.survey.api.dto.request.OptionG;
import com.cristianbyte.survey.domain.entities.OptionQs;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OptionMapper {
    @Mapping(target = "question.id", source = "question")
    OptionQs optiongToOptionqs(OptionG option);
    
    @Mapping(target = "question", ignore= true)
    OptionG optionqsToOptionqG(OptionQs option);

    @Mapping(target = "question.id", source = "question")
    void updateFromOptionG(OptionG request, @MappingTarget OptionQs option);
}
