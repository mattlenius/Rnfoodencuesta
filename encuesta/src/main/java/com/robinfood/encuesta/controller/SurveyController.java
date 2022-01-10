package com.robinfood.encuesta.controller;

import com.robinfood.encuesta.domain.Survey;
import com.robinfood.encuesta.service.ISurveyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/robinfood")
public class SurveyController {

    @Autowired
    private ISurveyService iSurveyService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveSurvey(@RequestBody @Validated Survey survey) throws ResponseStatusException, SQLException {
        log.debug("se va realizar el registro de encuesta", survey);
        if (iSurveyService.saveSurvey(survey)) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("the survey was successfully registered");
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("survey already exists enter another name");
        }


    }

    @GetMapping("/consult/{surveyname}")
    public ResponseEntity<Survey> getSurvey(@PathVariable("surveyname") String surveyname) throws SQLException {
        Survey survey = iSurveyService.consultSurvey(surveyname);
        log.info("is processed to generate dna statistics..");
        if (survey != null) {
            return ResponseEntity.ok(survey);
        } else {
            return null;
        }


    }


}
