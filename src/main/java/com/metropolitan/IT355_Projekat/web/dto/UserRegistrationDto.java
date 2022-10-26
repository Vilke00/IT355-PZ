package com.metropolitan.IT355_Projekat.web.dto;

public class UserRegistrationDto {
    private String ime;
    private String prezime;
    private String email;
    private String password;

    public UserRegistrationDto(String ime, String prezime, String email, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.password = password;
    }

    public UserRegistrationDto() {

    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
