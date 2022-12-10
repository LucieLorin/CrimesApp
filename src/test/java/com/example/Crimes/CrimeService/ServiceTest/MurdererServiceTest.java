package com.example.Crimes.CrimeService.ServiceTest;

import com.example.Crimes.CrimeRepository.MurdererRepository;
import com.example.Crimes.CrimeService.MurdererService;
import com.example.Crimes.Dtos.MurdererDto;
import com.example.Crimes.Entity.Murderer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class MurdererServiceTest {

    @InjectMocks
    private MurdererService murdererService;

    @Mock
    private MurdererRepository murdererRepository;


    @ParameterizedTest
    @ValueSource(strings = {"gacy", "GACY", "Gacy", "GAcy", "54965665", " "})
    public void getMurdererBySurname(String surname) {

        Murderer murderer = new Murderer();
        MurdererDto murdererDto = new MurdererDto();
        murdererDto.setSurname("Gacy");

        when(murdererRepository.getMurdererBySurname(surname)).thenReturn(murderer);

        assertEquals(murdererDto, murdererService.getMurdererBySurname(surname));

    }

    @ParameterizedTest
    @NullSource
    public void getMurdererBySurname_nullSource(String surname) {

        var result = murdererService.getMurdererBySurname(surname);

        assertNotNull(result);


    }

}
