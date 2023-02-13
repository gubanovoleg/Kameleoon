package com.example.kameleoon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Table(name = "quotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quote {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column(name = "quote")
    private String quote;

    @Column (name = "date")
    private Date date;

    @Column (name = "score")
    private Integer score;

    @JsonIgnore
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;


}
