package com.example.kameleoon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "accounts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "account_id")
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column (name= "password")
    private String password;

    @Column (name = "date")
    private Date date;

    @Column (name = "email")
    private String email;


    @OneToMany (mappedBy = "account", cascade = CascadeType.ALL)
    private List<Quote> quoteList;

//    @OneToMany (mappedBy = "account", cascade = CascadeType.ALL)
//    private List<LastVotedQuotes> lastVotedQuotesList;
}
