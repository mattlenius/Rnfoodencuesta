package com.robinfood.encuesta.entity;

import com.fasterxml.jackson.annotation.JsonRawValue;
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
@Table(name = "QUESTION", schema = "encuestaRobinFood")
@AllArgsConstructor
@NoArgsConstructor
public class QuestionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDQUESTION")
    private Long id;


    @JsonRawValue
    @Column(name = "QUESTION_SURVEY")
    private String questionSurvey;

    @Column(name = "REG_DATE")
    private Timestamp regDate;

    @OneToMany(mappedBy = "question")
    private List<QuestionSurveyEntity> questionSurveys;


}
