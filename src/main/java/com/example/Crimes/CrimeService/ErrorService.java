package com.example.Crimes.CrimeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ErrorService {

    /**
     * Random generator of excuses.
     * It's necessary to add more.
     */
    public String getExcuse(){

        List<String> excuses = new ArrayList<>();

        excuses.add("Only god knows.");
        excuses.add("Pes sežral html sheet.");
        excuses.add("Nefunguje pro vaše vlastní dobro!");
        excuses.add("Nevím.");
        excuses.add("Prší.");
        excuses.add("Webmaster je opilý.");
        excuses.add("Asi nejde wifi.");
        excuses.add("Tank neplave v medu.");
        excuses.add("Adminku bolí bříško.");

        Random randomExcuseGenerator = new Random();
        int excuseNumber = randomExcuseGenerator.nextInt(excuses.size());

        return excuses.get(excuseNumber);
    }
}
