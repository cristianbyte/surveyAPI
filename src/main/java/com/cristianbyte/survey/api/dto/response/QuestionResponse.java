package com.cristianbyte.survey.api.dto.response;

import com.cristianbyte.survey.util.QuestionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse{
    private int id;
    
    private String text;
    
    private QuestionType type;
    
    private int survey;
    
    private boolean active;

    //private List<OptionRequest> options;
}
