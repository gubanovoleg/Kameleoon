package com.example.kameleoon.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlopTenQuotesResponseDto {
    private Integer id;

    private String quote;

    private Integer score;


}
