package com.cristianbyte.survey.api.dto.request;

import java.util.List;

import com.cristianbyte.survey.util.QuestionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    
    @NotBlank(message="you must provide a text message")
    private String text;
    @Pattern(regexp = "OPEN|CLOSE",message="only OPEN or CLOSE arguments are allowed")
    private QuestionType type;
    @NotBlank(message="you must provide a reference for the survey")
    private int survey;
    @NotBlank(message="you must provide a status(active=?) for the survey")
    private boolean active;

    private List<OptionG> options;
}
