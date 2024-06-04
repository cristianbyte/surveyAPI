package com.cristianbyte.survey.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResponse {

    private int id;
    private String title;
    private String description;
    private String creationDate;
    private boolean active;
    private int creator;
}
