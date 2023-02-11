package com.example.kameleoon.service;


import com.example.kameleoon.dto.AddAccountRequestDto;
import com.example.kameleoon.entity.LastVotedQuotes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    void add(AddAccountRequestDto addAccountRequestDto);

    List<LastVotedQuotes> getLastVotedQuotes(int account_id);
}
