package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisniciModelTest {

    KorisniciModel korisnici = new KorisniciModel();
    @Test
    void setGetKorisnici() {
        ObservableList<Korisnik> korisniciExpected = FXCollections.observableArrayList();
        Korisnik k1 = new Korisnik();
        k1.setIme("Bakir");
        k1.setPrezime("Karovic");
        Korisnik k2 = new Korisnik();
        k2.setIme("Goran");
        k2.setPrezime("Jović");
        Korisnik k3 = new Korisnik();
        k3.setIme("Faris");
        k3.setPrezime("Baždar");
        korisniciExpected.addAll(k1, k2, k3);
        korisnici.setKorisnici(korisniciExpected);
        assertEquals(korisniciExpected, korisnici.getKorisnici());
    }

    @Test
    void setGetTrenutniKorisnik() {
        Korisnik trenutni = new Korisnik("Darko", "Randi", "drandi@test..com", "drandi1", "letMeIn");
        korisnici.setTrenutniKorisnik(trenutni);
        assertEquals(trenutni, korisnici.getTrenutniKorisnik());
    }

    @Test
    void trenutniKorisnikProperty() {

    }

    @BeforeEach
    void napuniTest() {
        korisnici.napuni();
    }

    @Test
    void addUser() {
        korisnici.addUser();
        assertEquals(4, korisnici.getKorisnici().size());
    }

    @Test
    void addUserSizeTest() {
        korisnici.addUser();
        assertEquals("noviKorisnik", korisnici.getKorisnici().get(3).getIme());
    }
}