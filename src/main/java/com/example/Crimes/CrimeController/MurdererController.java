package com.example.Crimes.CrimeController;

import com.example.Crimes.CrimeRepository.MurdererRepository;
import com.example.Crimes.Dtos.MurdererDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MurdererController {

    private MurdererRepository murdererRepository;

    @GetMapping("/murderer/{surname}")
    public ResponseEntity<MurdererDto> getMurderer(
            @PathVariable("surname")
                    String surname) {
        var murderer = murdererRepository.getMurdererBySurname(surname);
        return ResponseEntity.ok(murderer.toMurdererDto());
    }

}
