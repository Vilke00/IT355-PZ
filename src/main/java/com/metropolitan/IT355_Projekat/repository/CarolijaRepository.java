package com.metropolitan.IT355_Projekat.repository;

import com.metropolitan.IT355_Projekat.model.Carolija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarolijaRepository extends JpaRepository<Carolija, Long> {
}
