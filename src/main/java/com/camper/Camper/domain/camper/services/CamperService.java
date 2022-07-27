package com.camper.Camper.domain.camper.services;

import com.camper.Camper.domain.camper.models.CamperType;
import com.camper.Camper.domain.core.ResourceCreationException;
import com.camper.Camper.domain.core.ResourceNotFoundException;
import com.camper.Camper.domain.camper.models.Camper;

import java.util.List;

public interface CamperService {

    Camper create(Camper camper) throws ResourceCreationException;
    List<Camper> getAll();
    Camper getById(Long id) throws ResourceNotFoundException;
    List<Camper> getByLastName(Long id) throws ResourceNotFoundException;
    Camper getByEmail(String email) throws ResourceNotFoundException;

    List<Camper> getByCamperType(CamperType type);
    Camper update(Long id, Camper camperDetail) throws ResourceNotFoundException;
    void delete(Long id);
}