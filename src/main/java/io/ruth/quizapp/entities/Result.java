package io.ruth.quizapp.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class Result {
    @Id
    private int resultId;
    private double score;
    private String status;
    private String date;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "examineeId")
    private Examinee examinee;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "quizId")
    private Quiz quiz;

}
