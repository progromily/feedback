package com.example.feedback.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "response")
@Data
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long responseId;

    @Column(name = "response_rate")
    private int responseRate;

    @Column(name = "user_id")
    private long userId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "question_id", referencedColumnName = "questionId")
    private Question question;

}
