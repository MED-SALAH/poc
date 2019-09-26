package com.presentation.demo.model;

public class Description {

    private String prix;
    private String annee;
    private String garantie;

    public Description(String prix, String annee, String garantie) {
        this.prix = prix;
        this.annee = annee;
        this.garantie = garantie;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }


    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getGarantie() {
        return garantie;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }



}
