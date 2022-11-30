package com.example.Crimes.CrimeController;

import com.example.Crimes.CrimeService.CrimeService;
import com.example.Crimes.Dtos.CrimeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class CrimeController {

    private final CrimeService crimeService;

    @GetMapping("/todaysAnniversary")
    public ResponseEntity<CrimeDto> getMurderer() {
        return ResponseEntity.ok(crimeService.getTodaysAnniversaryCrime());
    }
}
