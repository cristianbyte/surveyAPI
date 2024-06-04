package com.cristianbyte.survey.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionG {
    @NotBlank(message="you must specify a content for the option")
    private String text;
    private boolean active;
    private int question;
}
