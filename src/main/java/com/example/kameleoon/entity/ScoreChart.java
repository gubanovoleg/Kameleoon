package com.example.kameleoon.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table (name = "score_chart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreChart {

    @Id
    @GeneratedValue
    @Column (name = "id")
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name="quote_id")
    private Integer quote_id;

    @Column (name = "score")
    private Integer score;


}
