package com.robinfood.encuesta.service;

import com.robinfood.encuesta.dataprovider.mysql.MysqlQuestionDataProvider;
import com.robinfood.encuesta.dataprovider.mysql.MysqlQuestionSurveyDataProvider;
import com.robinfood.encuesta.dataprovider.mysql.MysqlSurveyDataProvider;
import com.robinfood.encuesta.domain.OptionAnswer;
import com.robinfood.encuesta.domain.Question;
import com.robinfood.encuesta.domain.Survey;
import com.robinfood.encuesta.entity.QuestionEntity;
import com.robinfood.encuesta.entity.QuestionSurveyEntity;
import com.robinfood.encuesta.entity.SurveyEntity;
import com.robinfood.encuesta.util.DateFecha;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SurveyServiceTest {

    @InjectMocks
    private SurveyService surveyService ;
    @Mock
    private  MysqlQuestionSurveyDataProvider mysqlQuestionSurveyDataProvider;

    @Mock
    private MysqlQuestionDataProvider mysqlQuestionDataProvider;

    @Mock
    private MysqlSurveyDataProvider mysqlSurveyDataProvider;

    @Test
    public void saveSurveyFalse() throws SQLException {
        Mockito.when(mysqlSurveyDataProvider.findByName("ANIMALES")).thenReturn(SurveyEntity.builder().id(1L).name("ANIMALES").description("for view animals").build());
        List<Question> questions = new ArrayList<>();
        List<OptionAnswer> optionAnswers = new ArrayList<>();
        optionAnswers.add(OptionAnswer.builder().id("a").value("coffe").build());
        optionAnswers.add(OptionAnswer.builder().id("b").value("yellow").build());
        optionAnswers.add(OptionAnswer.builder().id("c").value("red").build());
        questions.add(Question.builder().questionSurvey("what is color the tiger").questionType("multi").optionAnswer(optionAnswers).build());
        optionAnswers = new ArrayList<>();
        optionAnswers.add(OptionAnswer.builder().id("1").value("").build());
        questions.add(Question.builder().questionSurvey("what is color the tiger").questionType("open").optionAnswer(optionAnswers).build());
        Boolean result = surveyService.saveSurvey(Survey.builder().descriptionSurvey("for view animals").nameSurvey("ANIMALES").question(questions).build());
        assertEquals(false, result);
    }

    @Test
    public void saveSurveyTrue() throws SQLException {
        List<Question> questions = new ArrayList<>();
        List<OptionAnswer> optionAnswers = new ArrayList<>();
        optionAnswers.add(OptionAnswer.builder().id("a").value("coffe").build());
        optionAnswers.add(OptionAnswer.builder().id("b").value("yellow").build());
        optionAnswers.add(OptionAnswer.builder().id("c").value("red").build());
        questions.add(Question.builder().questionSurvey("what is color the tiger").questionType("multi").optionAnswer(optionAnswers).build());
        optionAnswers = new ArrayList<>();
        optionAnswers.add(OptionAnswer.builder().id("1").value("").build());
        questions.add(Question.builder().questionSurvey("what is color the tiger").questionType("open").optionAnswer(optionAnswers).build());
        Boolean result = surveyService.saveSurvey(Survey.builder().descriptionSurvey("for view animals").nameSurvey("Animales").question(questions).build());
        assertEquals(true, result);
    }

    @Test
    public void consultSurvey() throws SQLException {
        Mockito.when(mysqlSurveyDataProvider.findByName("ANIMALES")).thenReturn(SurveyEntity.builder().id(1L).name("ANIMALES").description("for view animals").build());
        Mockito.when(mysqlQuestionSurveyDataProvider.findBySurvey(SurveyEntity.builder().id(1L).name("ANIMALES").description("for view animals").build())).thenReturn(QuestionSurveyEntity.builder().id(1L).question(QuestionEntity.builder().id(1L).questionSurvey("json").build()).survey(SurveyEntity.builder().id(1L).name("ANIMALES").description("for view animals").build()).build());
        Mockito.when(mysqlQuestionDataProvider.findById(1L)).thenReturn(QuestionEntity.builder().id(1L).questionSurvey("{\"question\": [{\"optionAnswer\": [{\"id\": \"a\", \"value\": \"coffe\"}, {\"id\": \"b\", \"value\": \"yellow\"}, {\"id\": \"c\", \"value\": \"red\"}], \"questionType\": \"multi\", \"questionSurvey\": \"what is color the lion\"}, {\"optionAnswer\": [{\"id\": \"a\", \"value\": \"coffe\"}, {\"id\": \"b\", \"value\": \"yellow\"}, {\"id\": \"c\", \"value\": \"red\"}], \"questionType\": \"multi\", \"questionSurvey\": \"what is color the tiger\"}, {\"optionAnswer\": [{\"id\": \"1\", \"value\": \"\"}], \"questionType\": \"open\", \"questionSurvey\": \"what is color the tiger\"}], \"nameSurvey\": \"Animales\", \"descriptionSurvey\": \"for view animals\"}").build());
        Survey result = surveyService.consultSurvey("ANIMALES");
        assertEquals("ANIMALES", result.getNameSurvey().toUpperCase());
    }

}
