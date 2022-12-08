package com.example.Crimes.CrimeService;

import com.example.Crimes.CrimeRepository.CrimeRepository;
import com.example.Crimes.CrimeRepository.MurdererRepository;
import com.example.Crimes.Dtos.CrimeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrimeService {

    private final CrimeRepository crimeRepository;
    private final MurdererRepository murdererRepository;

    public CrimeDto getTodaysAnniversaryCrime() {

        // z DB se podle aktualniho datumu vybere zlocinec, ktery ma dnes narozeniny
        // - k tomu je lepsi predelat ukladani narozenin v DB na format TIMESTAMP, ted je to ve Stringu a je to naprd

        // do murderer REPA vytvorit metodu, ktera vytahne zlocince podle porovnani localdate.now() a datumu narozeni
        // vzit jeho ID a podle FK vyhledat prislusny zlocin, ktery metoda vrati

        // pokud tam nebude, vyhodit nejake custom info, proc se dneska nenarodil zadnej vrah nebo tak

        var todaysCrime = new CrimeDto();

        todaysCrime.setDetails("Nic tu neni. #sorryJako");
        return todaysCrime;
    }

}
