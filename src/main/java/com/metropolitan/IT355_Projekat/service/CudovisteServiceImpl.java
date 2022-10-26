package com.metropolitan.IT355_Projekat.service;

import com.metropolitan.IT355_Projekat.model.Cudoviste;
import com.metropolitan.IT355_Projekat.repository.CudovisteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CudovisteServiceImpl implements CudovisteService{

    @Autowired
    private CudovisteRepository cudovisteRepository;

    @Override
    public List<Cudoviste> getAllCudovista() {
        return cudovisteRepository.findAll();
    }

    @Override
    public void saveCudoviste(Cudoviste cudoviste) {
        this.cudovisteRepository.save(cudoviste);
    }

    @Override
    public Cudoviste getCudovisteById(long id) {
        Optional<Cudoviste> optional = cudovisteRepository.findById(id);
        Cudoviste cudoviste = null;
        if (optional.isPresent()){
            cudoviste = optional.get();
        }
        else{
            throw new RuntimeException("Cudoviste sa id: " + id + " nije pronadjen");
        }
        return cudoviste;
    }

    @Override
    public void deleteCudovisteById(long id) {
        this.cudovisteRepository.deleteById(id);
    }
}
