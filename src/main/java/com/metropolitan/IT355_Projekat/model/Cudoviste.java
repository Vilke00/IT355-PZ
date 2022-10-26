package com.metropolitan.IT355_Projekat.model;

import javax.persistence.*;

@Entity
@Table(name = "cudoviste")
public class Cudoviste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cudoviste;

    @Column(name="ime")
    private String ime;

    @Column(name="atribut")
    private String atribut;

    @Column(name="archetype")
    private String archetype;
    @Column(name="efekat")
    private String efekat;


    public long getId_cudoviste() {
        return id_cudoviste;
    }

    public void setId_cudoviste(long id_cudoviste) {
        this.id_cudoviste = id_cudoviste;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getAtribut() {
        return atribut;
    }

    public void setAtribut(String atribut) {
        this.atribut = atribut;
    }

    public String getArchetype() {
        return archetype;
    }

    public void setArchetype(String archetype) {
        this.archetype = archetype;
    }

    public String getEfekat() {
        return efekat;
    }

    public void setEfekat(String efekat) {
        this.efekat = efekat;
    }
}
