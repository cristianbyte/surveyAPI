package com.cristianbyte.survey.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

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
    
    @Mapping(target = "question", source = "question.id")
    OptionG optionqsToOptionqG(OptionQs option);

    @Mapping(target = "question.id", source = "question")
    void updateFromOptionG(OptionG request, @MappingTarget OptionQs option);

    // Métodos de conversión de listas (pueden ser opcionales si MapStruct los genera automáticamente)
    default List<OptionQs> optionGListToOptionQsList(List<OptionG> options) {
        if (options == null) {
            return null;
        }
        return options.stream().map(this::optiongToOptionqs).collect(Collectors.toList());
    }

    default List<OptionG> optionQsListToOptionGList(List<OptionQs> options) {
        if (options == null) {
            return null;
        }
        return options.stream().map(this::optionqsToOptionqG).collect(Collectors.toList());
    }
}

