package com.metropolitan.IT355_Projekat.service;

import com.metropolitan.IT355_Projekat.model.Cudoviste;

import java.util.List;

public interface CudovisteService {
    List<Cudoviste> getAllCudovista();
    void saveCudoviste(Cudoviste cudoviste);
    Cudoviste getCudovisteById(long id);
    void deleteCudovisteById(long id);
}
