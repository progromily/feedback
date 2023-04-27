package com.example.feedback.controller;


import com.example.feedback.model.Question;
import com.example.feedback.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @PostMapping("/create-question")
    @CrossOrigin(origins = "*")
    public ResponseEntity createQuestion(
            @RequestParam(name = "questionTitle") String questionTitle,
            @RequestParam(name = "creatorId") Long creatorId,
            @RequestParam(name = "eventId") Long eventId
    ){
        if (questionTitle != null && creatorId != null && eventId != null) {
            Question question = new Question();
            question.setQuestionTitle(questionTitle);
            question.setCreatorId(creatorId);
            question.setEventId(eventId);
            questionRepository.save(question);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/get-questions")
    @CrossOrigin(origins = "*")
    public ResponseEntity getAllQuestions(
            @RequestParam(name = "eventId") Long eventId
    ) {
        if (eventId != null) {
            return ResponseEntity.status(HttpStatus.OK).body(questionRepository.findByEventId(eventId));
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/delete-question")
    @CrossOrigin(origins = "*")
    public ResponseEntity deleteQuestion(
            @RequestParam(name = "questionId") Long questionId
    ) {
        if (questionId != null) {
            questionRepository.deleteById(questionId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
