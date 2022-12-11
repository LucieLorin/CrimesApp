package com.example.Crimes.CrimeService;

import com.example.Crimes.CrimeRepository.MurdererRepository;
import com.example.Crimes.Dtos.MurdererDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class MurdererService {

    private final MurdererRepository murdererRepository;

    /**
     * Method returns Murderer from database by surname
     * Method also validates input data from FE
     */
    public MurdererDto getMurdererBySurname(String surname) {

        if (surname == null || surname.isBlank() || surname.isEmpty()) {
            log.info("Surname is null, blank or empty.");
            throw new NullPointerException("Cannot proceed request because: surname is missing.");
        }

        var surnameTrim = surname.trim();

        // capitalize funkce se jebe, nevim proc, tohle je jen reminder, vyresit az se vratim z brna
        var capitalizedSurname = StringUtils.capitalize(surnameTrim.toLowerCase());

        return (murdererRepository.getMurdererBySurname(surnameTrim)).toMurdererDto();

    }

    // TODO: create single validate method + validation class for univarsal usage

}
