package com.robinfood.encuesta.controller;

import com.robinfood.encuesta.domain.OptionAnswer;
import com.robinfood.encuesta.domain.Question;
import com.robinfood.encuesta.domain.Survey;
import com.robinfood.encuesta.service.ISurveyService;
import com.robinfood.encuesta.service.SurveyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SurveyControllerTest {
    @InjectMocks private SurveyController surveyController;
    @Mock private ISurveyService surveyService;

    @Test
    public void saveSurvey() throws ResponseStatusException, SQLException {
        List<Question> questions = new ArrayList<>();
        List<OptionAnswer> optionAnswers = new ArrayList<>();
        optionAnswers.add(OptionAnswer.builder().id("a").value("coffe").build());
        optionAnswers.add(OptionAnswer.builder().id("b").value("yellow").build());
        optionAnswers.add(OptionAnswer.builder().id("c").value("red").build());
        questions.add(Question.builder().questionSurvey("what is color the tiger").questionType("multi").optionAnswer(optionAnswers).build());
        optionAnswers = new ArrayList<>();
        optionAnswers.add(OptionAnswer.builder().id("1").value("").build());
        questions.add(Question.builder().questionSurvey("what is color the tiger").questionType("open").optionAnswer(optionAnswers).build());
        ResponseEntity<String> expected = surveyController.saveSurvey(Survey.builder().descriptionSurvey("for view animals").nameSurvey("ANIMALES").question(questions).build());
        assertEquals(HttpStatus.OK, expected.getStatusCode());
    }

    @Test
    public void consultSurvey() throws ResponseStatusException, SQLException {
        List<Question> questions = new ArrayList<>();
        List<OptionAnswer> optionAnswers = new ArrayList<>();
        optionAnswers.add(OptionAnswer.builder().id("a").value("coffe").build());
        optionAnswers.add(OptionAnswer.builder().id("b").value("yellow").build());
        optionAnswers.add(OptionAnswer.builder().id("c").value("red").build());
        questions.add(Question.builder().questionSurvey("what is color the tiger").questionType("multi").optionAnswer(optionAnswers).build());
        optionAnswers = new ArrayList<>();
        optionAnswers.add(OptionAnswer.builder().id("1").value("").build());
        questions.add(Question.builder().questionSurvey("what is color the tiger").questionType("open").optionAnswer(optionAnswers).build());
        Survey survey = Survey.builder().descriptionSurvey("for view animals").nameSurvey("ANIMALES").question(questions).build();
        Mockito.when(surveyService.consultSurvey("ANIMALES")).thenReturn(survey);
        ResponseEntity<Survey> expected = surveyController.getSurvey("ANIMALES");
        assertEquals(HttpStatus.OK, expected.getStatusCode());
    }

}
