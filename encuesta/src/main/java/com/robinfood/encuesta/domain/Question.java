package com.robinfood.encuesta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Question {
    private String questionSurvey;
    private List<OptionAnswer> optionAnswer;
    private String questionType;
}
