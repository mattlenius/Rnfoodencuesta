package com.robinfood.encuesta.dataprovider.mysql;


import com.robinfood.encuesta.entity.QuestionEntity;
import com.robinfood.encuesta.entity.QuestionSurveyEntity;
import com.robinfood.encuesta.entity.SurveyEntity;
import com.robinfood.encuesta.repository.QuestionSurveyRepository;
import com.robinfood.encuesta.repository.SurveyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MySqlQuestionSurveyDataProvideTest {

    @InjectMocks
    private MysqlQuestionSurveyDataProvider mysqlQuestionSurveyDataProvider ;
    @Mock
    private QuestionSurveyRepository questionSurveyRepository;

    @Test
    public void saveQuestion() throws SQLException {
        mysqlQuestionSurveyDataProvider.saveQuestionSurvey(QuestionSurveyEntity.builder().question(QuestionEntity.builder().id(1L).questionSurvey("json").build()).survey(SurveyEntity.builder().id(1L).name("Animales").description("for view animals").build()).build());
        verify(questionSurveyRepository).saveAndFlush(QuestionSurveyEntity.builder().question(QuestionEntity.builder().id(1L).questionSurvey("json").build()).survey(SurveyEntity.builder().id(1L).name("Animales").description("for view animals").build()).build());
    }

    @Test
    public void findBySurvey() {
        Mockito.when(questionSurveyRepository.findBySurvey(SurveyEntity.builder().id(1L).name("Animales").description("for view animals").build())).thenReturn(QuestionSurveyEntity.builder().id(1L).question(QuestionEntity.builder().id(1L).questionSurvey("json").build()).survey(SurveyEntity.builder().id(1L).name("Animales").description("for view animals").build()).build());
        QuestionSurveyEntity result = mysqlQuestionSurveyDataProvider.findBySurvey(SurveyEntity.builder().id(1L).name("Animales").description("for view animals").build());
        assertEquals(QuestionSurveyEntity.builder().id(1L).question(QuestionEntity.builder().id(1L).questionSurvey("json").build()).survey(SurveyEntity.builder().id(1L).name("Animales").description("for view animals").build()).build(), result);
    }
}
