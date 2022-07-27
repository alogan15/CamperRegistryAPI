package com.camper.Camper.domain.camper.repos;

import com.camper.Camper.domain.camper.models.Camper;
import com.camper.Camper.domain.camper.models.CamperType;
import com.camper.Camper.domain.camper.repos.CamperRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface CamperRepository extends JpaRepository<Camper, Long> {
    Optional<Camper> findByEmail(String email);
    Optional<Camper> findByLastName(String lastName);
    Optional<Camper> findByCamperType(CamperType type);
}