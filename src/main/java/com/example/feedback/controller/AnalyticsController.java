package com.example.feedback.controller;


import com.example.feedback.dto.AverageDTO;
import com.example.feedback.model.Question;
import com.example.feedback.model.Response;
import com.example.feedback.repository.QuestionRepository;
import com.example.feedback.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnalyticsController {

    @Autowired
    ResponseRepository responseRepository;

    @Autowired
    QuestionRepository questionRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/get-average-rates")
    public ResponseEntity getAverageRates(
            @RequestParam(name = "eventId") Long eventId
    ) {
        if (eventId != null) {
            List<Question> questions = questionRepository.findByEventId(eventId);
            List<AverageDTO> averageDTOList = new ArrayList<>();
            for (Question question : questions) {
                AverageDTO averageDTO = new AverageDTO();
                Float average = 0F;
                if (!question.getResponses().isEmpty()) {
                    for (Response response : question.getResponses()) {
                        average += response.getResponseRate();
                    }
                    average /= question.getResponses().size();
                    String stringAverage = String.format("%.2f", average);
                    averageDTO.setQuestionTitle(question.getQuestionTitle());
                    averageDTO.setAverage(stringAverage);
                    averageDTOList.add(averageDTO);
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(averageDTOList);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
