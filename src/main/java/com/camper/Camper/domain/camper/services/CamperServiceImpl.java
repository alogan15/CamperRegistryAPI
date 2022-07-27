package com.camper.Camper.domain.camper.services;


import com.camper.Camper.domain.camper.models.CamperType;
import com.camper.Camper.domain.core.ResourceCreationException;
import com.camper.Camper.domain.core.ResourceNotFoundException;
import com.camper.Camper.domain.camper.models.Camper;
import com.camper.Camper.domain.camper.repos.CamperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CamperServiceImpl implements CamperService{

    private CamperRepository camperRepository;

    @Autowired
    public CamperServiceImpl(CamperRepository camperRepository) {
        this.camperRepository = camperRepository;
    }

    @Override
    public Camper create(Camper camper) throws ResourceCreationException {
        Optional<Camper> optional = camperRepository.findByEmail(camper.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Camper with email exists: " + camper.getEmail());
        camper = camperRepository.save(camper);
        return camper;
    }

    @Override
    public Camper getById(Long id) throws ResourceNotFoundException {
        Camper camper = camperRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No camper with id: " + id));
        return camper;
    }

    @Override
    public List<Camper> getByLastName(Long id) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public Camper getByEmail(String email) throws ResourceNotFoundException {
        Camper camper = camperRepository.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No camper with email: " + email));
        return camper;
    }

    @Override
    public List<Camper> getByCamperType(CamperType type) {
        return null;
    }

    @Override
    public List<Camper> getAll() {
        return camperRepository.findAll();
    }

    @Override
    public Camper update(Long id, Camper camperDetail) throws ResourceNotFoundException {
        Camper camper = getById(id);
        camper.setFirstName(camperDetail.getFirstName());
        camper.setLastName(camperDetail.getLastName());
        camper.setEmail(camperDetail.getEmail());
        camper = camperRepository.save(camper);
        return camper;
    }

    @Override
    public void delete(Long id) {
        Camper camper = getById(id);
        camperRepository.delete(camper);
    }
}

