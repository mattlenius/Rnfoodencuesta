package com.robinfood.encuesta.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "SURVEY", schema = "encuestaRobinFood")
@AllArgsConstructor
@NoArgsConstructor
public class SurveyEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDSURVEY")
    private Long id;


    private String description;


    private String name;

    @Column(name = "REG_DATE")
    private Timestamp regDate;

    @OneToMany(mappedBy = "survey")
    private List<QuestionSurveyEntity> questionSurveys;
}
