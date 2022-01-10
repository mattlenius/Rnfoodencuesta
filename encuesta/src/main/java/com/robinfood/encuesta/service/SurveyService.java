package com.robinfood.encuesta.service;

import com.google.gson.Gson;
import com.robinfood.encuesta.dataprovider.QuestionDataProvider;
import com.robinfood.encuesta.dataprovider.QuestionSurveyDataProvider;
import com.robinfood.encuesta.dataprovider.SurveyDataProvider;
import com.robinfood.encuesta.domain.Survey;
import com.robinfood.encuesta.entity.QuestionEntity;
import com.robinfood.encuesta.entity.QuestionSurveyEntity;
import com.robinfood.encuesta.entity.SurveyEntity;
import com.robinfood.encuesta.util.DateFecha;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

@Log4j2
@Service
@AllArgsConstructor
public class SurveyService implements ISurveyService {

    @Autowired
    private QuestionSurveyDataProvider questionSurveyDataProvider;
    @Autowired
    private QuestionDataProvider questionDataProvider;
    @Autowired
    private SurveyDataProvider surveyDataProvider;


    @Override
    public boolean saveSurvey(Survey survey) throws ResponseStatusException, SQLException {
        Gson gson = new Gson();
        SurveyEntity surveyName = surveyDataProvider.findByName(survey.getNameSurvey().toUpperCase());
        if (surveyName != null) {
            return false;
        } else {
            SurveyEntity surveyEntity = surveyDataProvider.saveSurvey(SurveyEntity.builder().description(survey.getDescriptionSurvey()).name(survey.getNameSurvey()).regDate(new DateFecha().date()).build());
            QuestionEntity questionEntity = questionDataProvider.saveQuestion(QuestionEntity.builder().questionSurvey(gson.toJson(survey)).regDate(new DateFecha().date()).build());
            questionSurveyDataProvider.saveQuestionSurvey(QuestionSurveyEntity.builder().question(questionEntity).survey(surveyEntity).build());
            return true;
        }

    }

    @Override
    public Survey consultSurvey(String surveyname) throws ResponseStatusException, SQLException {
        SurveyEntity surveyName = surveyDataProvider.findByName(surveyname.toUpperCase());
        Gson gson = new Gson();
        if (surveyName != null) {
            QuestionSurveyEntity questionSurveyEntity = questionSurveyDataProvider.findBySurvey(surveyName);
            QuestionEntity questionEntity = questionDataProvider.findById(questionSurveyEntity.getId());
            Survey surve = gson.fromJson(questionEntity.getQuestionSurvey(), Survey.class);
            return surve;
        } else {
            return null;
        }
    }


}
