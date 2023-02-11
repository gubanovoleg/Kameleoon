package com.example.kameleoon.controller;

import com.example.kameleoon.dto.AddAccountRequestDto;
import com.example.kameleoon.entity.LastVotedQuotes;
import com.example.kameleoon.service.AccountService;
import com.example.kameleoon.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private QuoteService quoteService;

    // CREATE NEW ACCOUNT
    @PostMapping("/add")
    public void add(@RequestBody AddAccountRequestDto addAccountRequestDto){
        accountService.add(addAccountRequestDto);
    }



    // TAKE LAST FIVE VOTED QUOTES
    @GetMapping("/lastvoted/{account_id}")
    public List <LastVotedQuotes> getLastVotedQuotes(@PathVariable int account_id){
       return accountService.getLastVotedQuotes(account_id);

    }



}
