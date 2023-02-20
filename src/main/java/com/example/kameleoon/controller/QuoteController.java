package com.example.kameleoon.controller;


import com.example.kameleoon.dto.*;
import com.example.kameleoon.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quote")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;


    // GET RANDOM QUOTE
    @GetMapping("/random")
    public String getRandomQuote (){
        return quoteService.getRandomQuote();
    }


    // GET PARTICULAR QUOTE
    @GetMapping("/{id}")
    public GetQuoteRequestDto getParticularQuote (@PathVariable int id){
        return quoteService.getParticularQuote(id);
    }

    // GET TOP 10 QUOTES BY SCORE
    @GetMapping("/top")
    public List<TopTenQuotesResponseDto> getTopTenQuotes(){
        return quoteService.getTopTenQuotes();
    }

    // GET FLOP 10 QUOTES BY SCORE
    @GetMapping("/flop")
    public List<FlopTenQuotesResponseDto> getFlopTenQuotes(){
        return quoteService.getFlopTenQuotes();
    }

    // POST NEW QUOTE
    @PostMapping("/add")
    public void add(@RequestBody AddQuoteRequestDto addQuoteRequestDto){
        quoteService.addQuote(addQuoteRequestDto);
    }

    // CHANGE PARTICULAR QUOTE
    @PutMapping("/change")
    public void changeQuote (@RequestBody ChangeQuoteRequestDto changeQuoteRequestDto){
        quoteService.changeQuote(changeQuoteRequestDto);
    }
    // DELETE PARTICULAR QUOTE BY ID
    @DeleteMapping("/delete/{id}")
    public void deleteQuote (@PathVariable int id){
        quoteService.deleteQuote(id);
    }

    // PUT LIKE TO PARTICULAR QUOTE
    @PutMapping("/like")
    public void  addLikeToQuote (@RequestParam int quote_id){
        quoteService.addLikeToQuote(quote_id);

    }
    // PUT DISLIKE TO PARTICULAR QUOTE
    @PutMapping("/dislike")
    public void addDislikeToQuote (@RequestParam int quote_id){
        quoteService.addDislikeToQuote(quote_id);
    }

}
