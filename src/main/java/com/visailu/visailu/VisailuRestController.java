package com.visailu.visailu;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisailuRestController {

    VisailuService visailuService;
    Pelaaja nykyinenPelaaja;

    public VisailuRestController(VisailuService visailuService) {
        this.visailuService = visailuService;
    }

    @GetMapping("/") // Juurikansio jossa ohjeet
    public String homepage() {
        return "1. Luo käyttäjätunnus 2. Vastaa kysymyksiin 3. Kolme väärää vastausta sallittu";
    }

    @PostMapping("/pelaaja") // lisätään uusi pelaaja tietokantaan
    public String lisaPelaaja(@RequestBody Pelaaja pelaaja) {
        nykyinenPelaaja = new Pelaaja(pelaaja.kayttajanimi, pelaaja.etunimi, pelaaja.sukunimi);
        return visailuService.lisaPelaaja(pelaaja);
    }

    @GetMapping("/peli") // Peli alkaa ja level muuttujan avulla käydään hakemassa kysymys
    public ArrayList<String> peliKysymys(@RequestParam() String level) {
        return visailuService.getKysymys(level);
    }

    @PostMapping("/peli") // Body:ssa on käyttäjan antama vastaus ja parametrina käyttäjänimi
    public Boolean peliVastaus(@RequestBody String vastaus, @RequestParam() String id) {
        return visailuService.tarkistaVastaus(id, vastaus, nykyinenPelaaja);
    }

    @GetMapping("/tarkista") // Tarkistaa onko 3 väärää vastausta jo täynnä ja jatkuuko peli vielä
    public Boolean jatkuukoPeli() {
        return nykyinenPelaaja.jatkuukoPeli();
    }

    @GetMapping("/peliloppuu") // Peli loppuu ja näytetään pisteet
    public String peliLoppuu() {
        return "pisteet: " + nykyinenPelaaja.getPisteet();
    }

    @GetMapping("/pelaajainfo") // Pelaajatiedot
    public HashMap<String,String> pelaajaInfo() {
        return visailuService.pelaajaInfo(nykyinenPelaaja);
    }
}
