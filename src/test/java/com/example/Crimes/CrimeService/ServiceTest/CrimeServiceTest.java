package com.example.Crimes.CrimeService.ServiceTest;

import com.example.Crimes.CrimeRepository.CrimeRepository;
import com.example.Crimes.CrimeRepository.MurdererRepository;
import com.example.Crimes.CrimeService.CrimeService;
import com.example.Crimes.Entity.Crime;
import com.example.Crimes.Entity.Murderer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;


@RunWith(MockitoJUnitRunner.class)
class CrimeServiceTest {

    @InjectMocks
    private CrimeService crimeService;

    @Mock
    private CrimeRepository crimeRepository;

    @Mock
    private MurdererRepository murdererRepository;


    @Test //NOT WORKING YET
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

        doReturn(murderer).when(murdererRepository.getMurdererByBirthdate(birthdate));
        doReturn(crime).when(crimeRepository.getCrimeByMurdererId(1L));

        var result = crimeService.getTodaysAnniversaryCrime();

        assertNotNull(result);
        assertEquals(33, result.getVictims());
        assertEquals("Illinois", result.getCountry());
        assertEquals(1, (long) result.getMurdererId());
        assertEquals("details", result.getDetails());

    }
}
