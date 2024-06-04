package com.cristianbyte.survey.api.dto.response;


import java.util.List;

import com.cristianbyte.survey.api.dto.request.OptionG;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse{
    private int id;
    
    private String text;
    
    private String type;
    
    private int survey;
    
    private boolean active;

    private List<OptionG> options;
}
