package com.example.kameleoon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddQuoteRequestDto {

     private String quote;

     private Integer account_id;
}
