package com.example.feedback.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "question_id", referencedColumnName = "questionId")
    private List<Response> responses;
}
