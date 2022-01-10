package com.robinfood.encuesta.dataprovider.mysql;

import com.robinfood.encuesta.dataprovider.SurveyDataProvider;
import com.robinfood.encuesta.entity.SurveyEntity;
import com.robinfood.encuesta.repository.SurveyRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;


@Service
@AllArgsConstructor
public class MysqlSurveyDataProvider implements SurveyDataProvider {

    @Autowired
    private SurveyRepository surveyRepository;

    @Override
    public SurveyEntity saveSurvey(SurveyEntity surveyEntity) throws SQLException {
        SurveyEntity survey = surveyRepository.saveAndFlush(surveyEntity);
        return survey;
    }

    @Override
    public SurveyEntity findByName(String name) {
        SurveyEntity survey = surveyRepository.findByName(name);
        return survey;
    }
}
