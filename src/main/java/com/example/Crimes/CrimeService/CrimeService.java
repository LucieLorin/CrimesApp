package com.example.Crimes.CrimeService;

import com.example.Crimes.CrimeRepository.CrimeRepository;
import com.example.Crimes.CrimeRepository.MurdererRepository;
import com.example.Crimes.Dtos.CrimeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CrimeService {

    private final CrimeRepository crimeRepository;
    private final MurdererRepository murdererRepository;

    /**
     * Method returns CrimeDto
     * variable  localDate needs overwrite because of the lack of data in DB
     * correct value will be LocalDate.now()
     */
    public CrimeDto getTodaysAnniversaryCrime(LocalDate localDate) {

        localDate = LocalDate.of(1942, 3, 17);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = localDate.format(dateTimeFormatter);

        try {
            var murderer = murdererRepository.getMurdererByBirthdate(formattedDate);
            var actualCrime = crimeRepository.getCrimeByMurdererId(murderer.getId());
            return actualCrime.toCrimeDto();

        } catch (NullPointerException e) {
            throw new NullPointerException("The database does not contain any crimes for input date.");
        }
    }
    
}
