package com.robinfood.encuesta.dataprovider;

import com.robinfood.encuesta.entity.QuestionEntity;

import java.sql.SQLException;

public interface QuestionDataProvider {
    QuestionEntity saveQuestion(QuestionEntity questionEntity) throws SQLException;

    QuestionEntity findById(long id);
}
