package com.example.feedback.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long questionId;

    @Column(name = "question_title")
    private String questionTitle;

    @Column(name = "event_id")
    private long eventId;

    @Column(name = "creator_id")
    private long creatorId;
}
