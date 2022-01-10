package com.robinfood.encuesta.repository;

import com.robinfood.encuesta.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
}
