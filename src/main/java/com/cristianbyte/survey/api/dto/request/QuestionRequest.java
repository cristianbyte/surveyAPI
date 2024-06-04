package com.cristianbyte.survey.api.dto.request;

import java.util.List;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private String type;
    @NotNull(message="you must provide a reference for the survey")
    private int survey;
    @AssertTrue
    private boolean active;

    private List<OptionG> options;
}
