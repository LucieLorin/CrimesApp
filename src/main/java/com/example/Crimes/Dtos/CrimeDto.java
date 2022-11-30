package com.example.Crimes.Dtos;

import lombok.Data;

@Data
public class CrimeDto {

    private Long murdererId;
    private String country;
    private int numberOfVictims;
    private String details;

}
