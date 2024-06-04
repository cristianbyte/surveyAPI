package com.cristianbyte.survey.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequest {

    @NotBlank(message="you must provide a title")
    private String title;
    @NotBlank(message="provide a description")
    private String description;
    private boolean active;
    @NotNull(message="provide the name of the creator of the survey")
    private int creator;
}
