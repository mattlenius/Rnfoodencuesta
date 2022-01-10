package com.robinfood.encuesta.repository;

import com.robinfood.encuesta.entity.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<SurveyEntity, Long> {
    SurveyEntity findByName(String name);
}
