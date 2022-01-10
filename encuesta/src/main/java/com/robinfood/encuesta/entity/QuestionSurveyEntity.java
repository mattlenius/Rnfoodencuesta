package com.robinfood.encuesta.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "QUESTION_SURVEY", schema = "encuestaRobinFood")
@AllArgsConstructor
@NoArgsConstructor
public class QuestionSurveyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDQUESTION_SURVEY")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "QUESTIONFK")
    private QuestionEntity question;

    @ManyToOne
    @JoinColumn(name = "SURVEYFK")
    private SurveyEntity survey;


}
