package com.robinfood.encuesta.dataprovider;

import com.robinfood.encuesta.entity.QuestionSurveyEntity;
import com.robinfood.encuesta.entity.SurveyEntity;

import java.sql.SQLException;

public interface QuestionSurveyDataProvider {
    QuestionSurveyEntity saveQuestionSurvey(QuestionSurveyEntity questionSurveyEntity) throws SQLException;
    QuestionSurveyEntity findBySurvey(SurveyEntity surveyEntity);
}
