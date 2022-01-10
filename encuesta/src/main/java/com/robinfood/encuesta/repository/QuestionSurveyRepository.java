package com.robinfood.encuesta.repository;

import com.robinfood.encuesta.entity.QuestionSurveyEntity;
import com.robinfood.encuesta.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionSurveyRepository extends JpaRepository<QuestionSurveyEntity, Long> {

    QuestionSurveyEntity findBySurvey(SurveyEntity surveyEntity);
}
