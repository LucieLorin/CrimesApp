package com.example.Crimes.CrimeService;

import com.example.Crimes.CrimeRepository.CrimeRepository;
import com.example.Crimes.CrimeRepository.MurdererRepository;
import com.example.Crimes.Dtos.CrimeDto;
import com.example.Crimes.Entity.Crime;
import com.example.Crimes.Entity.Murderer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CrimeService {

    private final CrimeRepository crimeRepository;
    private final MurdererRepository murdererRepository;

    /**
     * Method returns CrimeDto
     * variable  dateMock is used because of lack of data in DB
     * correct value will be LocalDate.now()
     */
    public CrimeDto getTodaysAnniversaryCrime() {

        var dateMock = LocalDate.of(1942, 3, 17);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = dateMock.format(dateTimeFormatter);

        try {
            var murderer = murdererRepository.getMurdererByBirthdate(formattedDate);
            var actualCrime = crimeRepository.getCrimeByMurdererId(murderer.getId());
            return actualCrime.toCrimeDto();

        } catch (NullPointerException e) {
            throw new NullPointerException("The database does not contain any crimes for input date.");
        }
    }
}
