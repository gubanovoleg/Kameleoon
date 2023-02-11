package com.example.kameleoon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddAccountRequestDto {

    private String login;

    private String email;

    private String password;

}
