package com.example.feedback.repository;

import com.example.feedback.model.Response;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {

    @Transactional
    public void deleteByUserIdAndQuestionEventId(Long userId, Long eventId);

    public List<Response> findByQuestionEventId(Long eventId);

    public List<Response> findByUserIdAndQuestionEventId(Long userId, Long eventId);
}
