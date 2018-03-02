package com.example.ajdin.zavrsnirad.model;

/**
 * Created by ajdin on 28.2.2018..
 */

public class Artikli {
    private String image;
    private String naziv;
    private String barkod;
    private String cijena;

    public Artikli(String image, String naziv, String barkod, String cijena) {
        this.image = image;
        this.naziv = naziv;
        this.barkod = barkod;
        this.cijena = cijena;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public String getCijena() {
        return cijena;
    }

    public void setCijena(String cijena) {
        this.cijena = cijena;
    }
}
