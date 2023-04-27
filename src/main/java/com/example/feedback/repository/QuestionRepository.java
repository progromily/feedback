package com.example.feedback.repository;


import com.example.feedback.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findByQuestionId(Long questionId);

    List<Question> findByEventId(Long eventId);
}
