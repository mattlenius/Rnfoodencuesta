package com.robinfood.encuesta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OptionAnswer {
    private String id;
    private String value;
}
