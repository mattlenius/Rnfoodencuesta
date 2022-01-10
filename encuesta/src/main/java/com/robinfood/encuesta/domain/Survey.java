package com.robinfood.encuesta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Survey {

    private String descriptionSurvey;
    private String nameSurvey;
    private List<Question> question;


}
