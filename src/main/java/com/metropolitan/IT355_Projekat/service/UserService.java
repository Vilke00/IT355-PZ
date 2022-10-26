package com.metropolitan.IT355_Projekat.service;

import com.metropolitan.IT355_Projekat.model.User;
import com.metropolitan.IT355_Projekat.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);
    List<User> getAllKorisnici();
    void saveKorisnik(User user);
    User getUserById(long id);
    void deleteUserById(long id);
}
