package com.example.kameleoon.dto;

import com.example.kameleoon.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQuoteRequestDto {

     private Integer id;

     private String quote;

     private Integer score;

     private Date date;

     private Integer account_id;

}
