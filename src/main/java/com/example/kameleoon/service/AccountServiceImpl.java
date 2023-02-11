package com.example.kameleoon.service;


import com.example.kameleoon.dto.AddAccountRequestDto;
import com.example.kameleoon.entity.Account;
import com.example.kameleoon.entity.LastVotedQuotes;
import com.example.kameleoon.repository.AccountRepository;
import com.example.kameleoon.repository.VotedQuoteRepository;
import com.example.kameleoon.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private VotedQuoteRepository votedQuoteRepository;

    @Override
    public void add(AddAccountRequestDto addAccountRequestDto) {
        Account account = new Account();
        account.setLogin(addAccountRequestDto.getLogin());
        account.setEmail(addAccountRequestDto.getEmail());
        account.setPassword(addAccountRequestDto.getPassword());
        account.setDate(new Date());
        accountRepository.save(account);
    }



    @Override
    public List<LastVotedQuotes> getLastVotedQuotes(int account_id) {
        return votedQuoteRepository.listLastVotedQuote(account_id);

    }


}
