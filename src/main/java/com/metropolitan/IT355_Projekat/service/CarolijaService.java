package com.metropolitan.IT355_Projekat.service;

import com.metropolitan.IT355_Projekat.model.Carolija;

import java.util.List;

public interface CarolijaService {
    List<Carolija> getAllCarolije();
    void saveCarolija(Carolija carolija);
    Carolija getCarolijaById(long id);
    void deleteCarolijaById(long id);
}
