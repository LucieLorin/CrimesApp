package com.example.Crimes.CrimeRepository;

import com.example.Crimes.Entity.Murderer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface MurdererRepository extends JpaRepository <Murderer, Long> {

    Murderer getMurdererBySurname(String surname);

    Murderer getMurdererById(Long id);

    Murderer getMurdererByBirthdate(String birthdate);
}
