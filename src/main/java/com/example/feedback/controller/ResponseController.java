package com.example.feedback.controller;


import com.example.feedback.model.Question;
import com.example.feedback.repository.QuestionRepository;
import com.example.feedback.repository.ResponseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.feedback.model.Response;

@RestController
@Transactional
public class ResponseController {

    @Autowired
    ResponseRepository responseRepository;

    @Autowired
    QuestionRepository questionRepository;


    @GetMapping("/get-responses")
    public ResponseEntity getResponses(
            @RequestParam(name = "eventId") Long eventId
    ) {
        if (eventId != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responseRepository.findByQuestionEventId(eventId));
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/get-responses-by-user")
    public ResponseEntity getResponsesByUser(
            @RequestParam(name = "eventId") Long eventId,
            @RequestParam(name = "userId") Long userId
    ) {
        if (eventId != null && userId != null) {
            return ResponseEntity.status(HttpStatus.OK).body(responseRepository.findByUserIdAndQuestionEventId(userId, eventId));
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/add-response")
    public ResponseEntity addResponse(
            @RequestParam(name = "responseRate") Integer responseRate,
            @RequestParam(name = "questionId") Long questionId,
            @RequestParam(name = "userId") Long userId
    ) {
        if (responseRate != null && questionId != null && userId != null) {
            Question question = questionRepository.findByQuestionId(questionId);
            Response response = new Response();
            response.setResponseRate(responseRate);
            response.setQuestion(question);
            response.setUserId(userId);
            responseRepository.save(response);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/delete-responses")
    public ResponseEntity deleteResponses(
            @RequestParam(name = "userId") Long userId,
            @RequestParam(name = "eventId") Long eventId
    ){
        if (userId != null && eventId != null) {
            responseRepository.deleteByUserIdAndQuestionEventId(userId, eventId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
