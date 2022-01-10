package com.robinfood.encuesta.dataprovider.mysql;

import com.robinfood.encuesta.dataprovider.QuestionDataProvider;
import com.robinfood.encuesta.entity.QuestionEntity;
import com.robinfood.encuesta.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MysqlQuestionDataProvider implements QuestionDataProvider {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public QuestionEntity saveQuestion(QuestionEntity questionEntity) throws SQLException {
        QuestionEntity question = questionRepository.saveAndFlush(questionEntity);
        return question;
    }

    @Override
    public QuestionEntity findById(long id) {
        Optional<QuestionEntity> questionOptional = questionRepository.findById(id);
        QuestionEntity questionEntity = questionOptional.isPresent() ? questionOptional.get() : null;
        return questionEntity;
    }
}
