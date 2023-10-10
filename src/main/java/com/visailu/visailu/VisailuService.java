package com.visailu.visailu;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class VisailuService {

    public String lisaPelaaja(Pelaaja pelaaja) {
        // lisätään uusi pelaaja tietokantaan
        return "pelaaja lisätty";
    }

    public ArrayList<String>  getKysymys(String level) {
        // Haetaan tietokannasta kysymys levelin mukaan, vastaan saadaan array jossa [0]=kysymyksen ID ja [1]=itse kysymys
        ArrayList <String> kysymys=new ArrayList<>();
        return kysymys;
    }

    public Boolean tarkistaVastaus(String kysID, String vastaus, Pelaaja nykyinenPelaaja) {
        String oikeaVastaus = "tietokannasta haettu oikea vastaus";//kysID mukaan
        //System.out.println(vastaus);
        //System.out.println(oikeaVastaus);
        Boolean tulos = oikeaVastaus.equals(vastaus) ? true : false;

        if (tulos) {
            nykyinenPelaaja.setPisteet(nykyinenPelaaja.getPisteet() + 1);
        } else {
            nykyinenPelaaja.setVaariaVastauksia(nykyinenPelaaja.getVaariaVastauksia() + 1);
        }
        return tulos;
    }

    public HashMap<String, String> pelaajaInfo(Pelaaja nykyinenPelaaja) {
        HashMap<String, String> info = new HashMap<>();

        info.put("kayttajanimi", nykyinenPelaaja.getKayttajanimi());
        info.put("etunimi", nykyinenPelaaja.getEtunimi());
        info.put("sukunimi", nykyinenPelaaja.getSukunimi());
        info.put("vaariaVastauksia", Integer.toString(nykyinenPelaaja.getVaariaVastauksia()));
        info.put("pisteet", Integer.toString(nykyinenPelaaja.getPisteet()));

        return info;

    }
}
