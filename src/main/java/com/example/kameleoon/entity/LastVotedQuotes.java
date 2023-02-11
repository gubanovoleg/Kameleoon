package com.example.kameleoon.entity;

import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Table(name = "voted_quotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LastVotedQuotes {

    @Id
    @Column(name = "quote_id")

    private Integer quote_id;

    @Column(name = "quote")
    private String quote;

    @Column(name = "date")
    private Date date;

    @Column (name = "account_id")
    private Integer account_id;

}
