package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorisnikTest {





    @Test
    void setIme() {
        Korisnik k = new Korisnik();
        k.setIme("Bakir");
        assertEquals("Bakir", k.getIme());
    }



    @Test
    void setPrezime() {
        Korisnik k = new Korisnik();
        k.setPrezime("Karovic");
        assertEquals("Karovic", k.getPrezime());
    }

    @Test
    void getEmail() {
        Korisnik k = new Korisnik();
        k.setEmail("bkarovic1@etf.unsa.ba");
        assertEquals("bkarovic1@etf.unsa.ba", k.getEmail());
    }

    @Test
    void imeProperty() {
        Korisnik k = new Korisnik();
        SimpleStringProperty ime = new SimpleStringProperty("noviKorisnik");
        assertEquals(ime, k.imeProperty());
    }

    @Test
    void emailProperty() {
        Korisnik k = new Korisnik();
        k.setEmail("test1@test.com");
        assertEquals("StringProperty [value: test1@test.com]", k.emailProperty());
    }

    @Test
    void prezimeProperty() {
        Korisnik k = new Korisnik();
        k.setPrezime("Hara");
        assertEquals("StringProperty [value: Hara]", k.prezimeProperty());
    }

    @Test
    void usernameProperty() {
        Korisnik k = new Korisnik();
        k.setUsername("test1");
        assertEquals("StringProperty [value: test1]", k.usernameProperty());
    }
    @Test
    void passwordProperty() {
        Korisnik k = new Korisnik();
        k.setPassword("letMeIn");
        assertEquals("StringProperty [value: letMeIn]", k.passwordProperty());
    }

    @Test
    void setUsername() {
        Korisnik k = new Korisnik();
        k.setUsername("bkarovic1");
        assertEquals("bkarovic1", k.getUsername());
    }


    @Test
    void setPassword() {
        Korisnik k = new Korisnik();
        k.setUsername("bkarovic1");
        assertEquals("bkarovic1", k.getUsername());
    }

    @Test
    void toStringTest() {
        Korisnik k = new Korisnik();
        k.setIme("Faris");
        k.setPrezime("Bazdar");
        assertEquals("Faris Bazdar", k.toString());


    }

}