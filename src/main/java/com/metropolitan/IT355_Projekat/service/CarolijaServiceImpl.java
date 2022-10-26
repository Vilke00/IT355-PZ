package com.metropolitan.IT355_Projekat.service;

import com.metropolitan.IT355_Projekat.model.Carolija;
import com.metropolitan.IT355_Projekat.repository.CarolijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarolijaServiceImpl implements CarolijaService {

    @Autowired
    private CarolijaRepository carolijaRepository;

    @Override
    public List<Carolija> getAllCarolije() {
        return carolijaRepository.findAll();
    }

    @Override
    public void saveCarolija(Carolija carolija) {
        this.carolijaRepository.save(carolija);
    }

    @Override
    public Carolija getCarolijaById(long id) {
        Optional<Carolija> optional = carolijaRepository.findById(id);
        Carolija carolija = null;
        if (optional.isPresent()){
            carolija = optional.get();
        }
        else{
            throw new RuntimeException("Carolija sa id: " + id + " nije pronadjen");
        }
        return carolija;
    }

    @Override
    public void deleteCarolijaById(long id) {
        this.carolijaRepository.deleteById(id);
    }
}
