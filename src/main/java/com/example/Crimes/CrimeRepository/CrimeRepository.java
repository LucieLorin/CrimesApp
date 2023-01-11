package com.example.Crimes.CrimeRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Crimes.Entity.Crime;

public interface CrimeRepository extends JpaRepository <Crime, Long> {

    Crime getCrimeByMurdererId(Long id);
    List<Crime> getCrimesByCountry(String country); // country bude pozdeji ENUM ?? Bylo by to vic odolny vuci preklepum.
}
