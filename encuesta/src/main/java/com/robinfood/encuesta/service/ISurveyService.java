package com.robinfood.encuesta.service;

import com.robinfood.encuesta.domain.Survey;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

public interface ISurveyService {
    boolean saveSurvey(Survey survey) throws ResponseStatusException, SQLException;

    Survey consultSurvey(String surveyname) throws ResponseStatusException, SQLException;
}
