package com.robinfood.encuesta.dataprovider.mysql;

import com.robinfood.encuesta.entity.QuestionEntity;
import com.robinfood.encuesta.entity.SurveyEntity;
import com.robinfood.encuesta.repository.QuestionRepository;
import com.robinfood.encuesta.repository.SurveyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class MySqlQuestionDataProviderTest {

    @InjectMocks
    private MysqlQuestionDataProvider mysqlQuestionDataProvider;
    @Mock
    private QuestionRepository questionRepository;

    @Test
    public void saveQuestion() throws SQLException {
        mysqlQuestionDataProvider.saveQuestion(QuestionEntity.builder().questionSurvey("json").build());
        verify(questionRepository).saveAndFlush(QuestionEntity.builder().questionSurvey("json").build());

    }

    @Test
    public void findById() {
        Optional<QuestionEntity> question= Optional.of(QuestionEntity.builder().id(1L).questionSurvey("json").build());
        Mockito.when(questionRepository.findById(1L)).thenReturn(question);
        QuestionEntity result = mysqlQuestionDataProvider.findById(1L);
        assertEquals(QuestionEntity.builder().id(1L).questionSurvey("json").build(), result);
    }
}
