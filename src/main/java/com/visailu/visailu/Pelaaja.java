package com.visailu.visailu;

public class Pelaaja {
    String kayttajanimi;
    String etunimi;
    String sukunimi;
    Integer pisteet;
    Integer vaariaVastauksia;

    public Pelaaja(String kayttajanimi, String etunimi, String sukunimi) {
        this.kayttajanimi = kayttajanimi;
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.vaariaVastauksia = 0;
        this.pisteet = 0;
    }

    public String getKayttajanimi() {
        return this.kayttajanimi;
    }

    public String getEtunimi() {
        return this.etunimi;
    }

    public String getSukunimi() {
        return this.sukunimi;
    }

    public Integer getPisteet() {
        return this.pisteet;
    }

    public void setPisteet(Integer pisteet) {
        this.pisteet = pisteet;
    }

    public Boolean jatkuukoPeli() {    
        return this.vaariaVastauksia==3?false:true;
    }

     public int getVaariaVastauksia() {    
        return this.vaariaVastauksia;
    }

    public void setVaariaVastauksia(Integer vaariaVastauksia) {
        this.vaariaVastauksia = vaariaVastauksia;
    }

}
