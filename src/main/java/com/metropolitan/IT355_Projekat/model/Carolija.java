package com.metropolitan.IT355_Projekat.model;

import javax.persistence.*;

@Entity
@Table(name = "carolija")
public class Carolija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_carolija;

    @Column(name="ime")
    private String ime;
    @Column(name="tip")
    private String tip;
    @Column(name="efekat")
    private String efekat;

    public long getId_carolija() {
        return id_carolija;
    }

    public void setId_carolija(long id_carolija) {
        this.id_carolija = id_carolija;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getEfekat() {
        return efekat;
    }

    public void setEfekat(String efekat) {
        this.efekat = efekat;
    }
}
