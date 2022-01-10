package com.robinfood.encuesta.dataprovider.mysql;


import com.robinfood.encuesta.dataprovider.QuestionSurveyDataProvider;
import com.robinfood.encuesta.entity.QuestionSurveyEntity;
import com.robinfood.encuesta.entity.SurveyEntity;
import com.robinfood.encuesta.repository.QuestionSurveyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MysqlQuestionSurveyDataProvider implements QuestionSurveyDataProvider {

    @Autowired
    private QuestionSurveyRepository questionSurveyRepository;


    @Override
    public QuestionSurveyEntity saveQuestionSurvey(QuestionSurveyEntity questionSurveyEntity) throws SQLException {
        QuestionSurveyEntity questionSurvey = questionSurveyRepository.saveAndFlush(questionSurveyEntity);
        return questionSurvey;
    }

    @Override
    public QuestionSurveyEntity findBySurvey(SurveyEntity surveyEntity) {
        QuestionSurveyEntity questionSurvey = questionSurveyRepository.findBySurvey(surveyEntity);
        return questionSurvey;
    }
}
