package com.robinfood.encuesta.dataprovider.mysql;

import com.robinfood.encuesta.entity.SurveyEntity;
import com.robinfood.encuesta.repository.SurveyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

@RunWith(MockitoJUnitRunner.class)
public class MysqlSurveyDataProviderTest {

    @InjectMocks private MysqlSurveyDataProvider mysqlSurveyDataProvider;
    @Mock private SurveyRepository surveyRepository;

    @Test
    public void saveQuestion() throws SQLException {
        mysqlSurveyDataProvider.saveSurvey(SurveyEntity.builder().name("Animales").description("for view animals").build());
        verify(surveyRepository).saveAndFlush(SurveyEntity.builder().name("Animales").description("for view animals").build());

    }

    @Test
    public void findByName() {
        Mockito.when(surveyRepository.findByName("Animales")).thenReturn(SurveyEntity.builder().id(1L).name("Animales").description("for view animals").build());
        SurveyEntity result = mysqlSurveyDataProvider.findByName("Animales");
        assertEquals(SurveyEntity.builder().id(1L).name("Animales").description("for view animals").build(), result);
    }

}
