package com.robinfood.encuesta.dataprovider;


import com.robinfood.encuesta.entity.SurveyEntity;

import java.sql.SQLException;

public interface SurveyDataProvider {
    SurveyEntity saveSurvey(SurveyEntity surveyEntity) throws SQLException;

    SurveyEntity findByName(String name);
}
