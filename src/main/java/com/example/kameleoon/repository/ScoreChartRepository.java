package com.example.kameleoon.repository;

import com.example.kameleoon.entity.ScoreChart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Repository
public interface ScoreChartRepository extends JpaRepository<ScoreChart, Date> {

    // DATA FOR GRAPH OF PARTICULAR QUOTE
    @Query (value = "SELECT * FROM score_chart WHERE quote_id =:quote_id ORDER BY date", nativeQuery = true)
    List<ScoreChart> takeDataForScoreCharParticularQuote (@Param("quote_id") int quote_id);

}
