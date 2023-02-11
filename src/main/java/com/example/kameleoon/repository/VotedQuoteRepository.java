package com.example.kameleoon.repository;

import com.example.kameleoon.entity.LastVotedQuotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VotedQuoteRepository extends JpaRepository<LastVotedQuotes, Integer> {

    @Query(value= "SELECT * FROM voted_quotes WHERE account_id = :account_id ORDER BY date DESC LIMIT 5", nativeQuery = true)
    List<LastVotedQuotes> listLastVotedQuote(@Param("account_id") int account_id);

}
