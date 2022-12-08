package com.example.Crimes.CrimeService.ServiceTest;

import com.example.Crimes.CrimeRepository.CrimeRepository;
import com.example.Crimes.CrimeRepository.MurdererRepository;
import com.example.Crimes.CrimeService.CrimeService;
import com.example.Crimes.Entity.Crime;
import com.example.Crimes.Entity.Murderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CrimeServiceTest {

    @InjectMocks
    private CrimeService crimeService;

    @Mock
    private CrimeRepository crimeRepository;

    @Mock
    private MurdererRepository murdererRepository;


    @Test
    public void getTodaysAnniversaryCrimeTest_crimePresent() {

        var birthdate = "1942-03-17";

        var murderer = new Murderer();
        murderer.setBirthdate(birthdate);
        murderer.setId(1L);

        var crime = new Crime();
        crime.setVictims(33);
        crime.setCountry("Illinois");
        crime.setMurdererId(1L);
        crime.setDetails("details");

        when(murdererRepository.getMurdererByBirthdate(birthdate)).thenReturn(murderer);
        when(crimeRepository.getCrimeByMurdererId(1L)).thenReturn(crime);

        var result = crimeService.getTodaysAnniversaryCrime(LocalDate.of(1942, 3, 17));

        assertNotNull(result);
        assertEquals(33, result.getVictims());
        assertEquals("Illinois", result.getCountry());
        assertEquals(1, (long) result.getMurdererId());
        assertEquals("details", result.getDetails());

    }

    @Test
    public void getTodaysAnniversaryCrimeTest_crimeNotPresent() {

        assertThrows(NullPointerException.class, () -> crimeService.getTodaysAnniversaryCrime(LocalDate.of(2011, 2, 2)));

    }
}
