package com.example.kameleoon.service;


import com.example.kameleoon.dto.*;
import com.example.kameleoon.entity.Quote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface QuoteService  {
    void addQuote(AddQuoteRequestDto addQuoteRequestDto);



    void changeQuote(ChangeQuoteRequestDto changeQuoteRequestDto);

    void deleteQuote(int id);

    String getRandomQuote();


    List<TopTenQuotesResponseDto> getTopTenQuotes();

    List<FlopTenQuotesResponseDto> getFlopTenQuotes();

    GetQuoteRequestDto getParticularQuote(int id);

    void  addLikeToQuote(int quote_id);

    void addDislikeToQuote(int quote_id);
}
