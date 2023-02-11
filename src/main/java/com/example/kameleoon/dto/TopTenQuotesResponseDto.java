package com.example.kameleoon.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopTenQuotesResponseDto {
    private Integer id;

    private String quote;

    private Integer score;


}
