package com.example.kameleoon.service;


import com.example.kameleoon.dto.*;
import com.example.kameleoon.entity.Account;
import com.example.kameleoon.entity.LastVotedQuotes;
import com.example.kameleoon.entity.Quote;
import com.example.kameleoon.entity.ScoreChart;
import com.example.kameleoon.repository.AccountRepository;
import com.example.kameleoon.repository.ScoreChartRepository;
import com.example.kameleoon.repository.VotedQuoteRepository;
import com.example.kameleoon.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class QuoteServiceImpl implements QuoteService{

    @Autowired
    private ScoreChartRepository scoreChartRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private VotedQuoteRepository votedQuoteRepository;

    @Override
    public void addQuote(AddQuoteRequestDto addQuoteRequestDto) {
        Quote quote = new Quote();
        quote.setQuote(addQuoteRequestDto.getQuote());
        quote.setScore(0);
        quote.setDate(new Date());
        Account byId = accountRepository.getById(addQuoteRequestDto.getAccount_id());
        quote.setAccount(byId);
        quoteRepository.save(quote);
    }

    @Override
    public void changeQuote(ChangeQuoteRequestDto changeQuoteRequestDto) {
        Quote byId = quoteRepository.getById(changeQuoteRequestDto.getQuote_id());
        byId.setQuote(changeQuoteRequestDto.getQuote());
        byId.setDate(new Date());
        quoteRepository.save(byId);
    }

    @Override
    public void deleteQuote(int id) {
        Quote byId = quoteRepository.getById(id);
        quoteRepository.delete(byId);
    }

    @Override
    public String getRandomQuote() {
        List<Quote> allQuote = quoteRepository.findAll();
        int size = allQuote.size();
        Quote quote = allQuote.get(new Random().nextInt(size));
        return quote.getQuote();
    }


    @Override
    public List<TopTenQuotesResponseDto> getTopTenQuotes() {
        return quoteRepository.findAll().stream()
                .sorted((o1, o2) -> o2.getScore() - o1.getScore())
                .limit(10)
                .map(quote -> {
                    TopTenQuotesResponseDto topTenQuotesResponseDto = new TopTenQuotesResponseDto();
                    topTenQuotesResponseDto.setId(quote.getId());
                    topTenQuotesResponseDto.setQuote(quote.getQuote());
                    topTenQuotesResponseDto.setScore(quote.getScore());
                    return topTenQuotesResponseDto;
                }).toList();
}

    @Override
    public List<FlopTenQuotesResponseDto> getFlopTenQuotes() {

        return quoteRepository.findAll().stream()
                .sorted((o1, o2) -> o1.getScore() - o2.getScore())
                .limit(10)
                .map(quote -> {
                    FlopTenQuotesResponseDto flopTenQuotesResponseDto = new FlopTenQuotesResponseDto();
                    flopTenQuotesResponseDto.setId(quote.getId());
                    flopTenQuotesResponseDto.setQuote(quote.getQuote());
                    flopTenQuotesResponseDto.setScore(quote.getScore());
                    return flopTenQuotesResponseDto;
                }).toList();
    }

    @Override
    public GetQuoteRequestDto getParticularQuote(int id) {
       Quote quote = quoteRepository.getById(id);
        GetQuoteRequestDto getQuoteRequestDto = new GetQuoteRequestDto();
        getQuoteRequestDto.setQuote(quote.getQuote());
        getQuoteRequestDto.setId(quote.getId());
        getQuoteRequestDto.setScore(quote.getScore());
        getQuoteRequestDto.setDate(quote.getDate());
        getQuoteRequestDto.setAccount_id(quote.getAccount().getId());

        return getQuoteRequestDto;
    }

    @Override
    public void addLikeToQuote(int quote_id, int account_id) {
        Quote quoteById = quoteRepository.getById(quote_id);
        quoteById.setScore(quoteById.getScore()+1);
        extractToLastVotedQuotes(quoteById);
        saveVotesAndDateIntoScoreChart(quoteById);

    }

    @Override
    public void addDislikeToQuote(int quote_id, int account_id) {
        Quote quoteById = quoteRepository.getById(quote_id);
        quoteById.setScore(quoteById.getScore()-1);
        extractToLastVotedQuotes(quoteById);
        saveVotesAndDateIntoScoreChart(quoteById);


    }

    protected void extractToLastVotedQuotes(Quote quoteById) {
        quoteRepository.save(quoteById);
        LastVotedQuotes lastVotedQuotes = new LastVotedQuotes();
        lastVotedQuotes.setQuote_id(quoteById.getId());
        lastVotedQuotes.setQuote(quoteById.getQuote());
        lastVotedQuotes.setDate(new Date());
        lastVotedQuotes.setAccount_id(quoteById.getAccount().getId());
        votedQuoteRepository.save(lastVotedQuotes);

    }


    protected void saveVotesAndDateIntoScoreChart(Quote quote){
        ScoreChart scoreChart = new ScoreChart();
        scoreChart.setScore(quote.getScore());
        scoreChart.setQuote_id(quote.getId());
        scoreChart.setDate(new Date());
        scoreChartRepository.save(scoreChart);

    }

    // DATA FOR GRAPH OF PARTICULAR QUOTE
    public List<ScoreChart> getDataForGraphOfParticularQuote(int quote_id) {
        List<ScoreChart> scoreChartList = scoreChartRepository.takeDataForScoreCharParticularQuote(quote_id);
        System.out.println(scoreChartList);
        return scoreChartList;
    }


}
