package sample;

import javafx.beans.property.SimpleStringProperty;

public class Korisnik {
    private SimpleStringProperty ime = new SimpleStringProperty("noviKorisnik");
    private SimpleStringProperty prezime = new SimpleStringProperty("");
    private SimpleStringProperty email = new SimpleStringProperty("");
    private SimpleStringProperty username = new SimpleStringProperty("");
    private SimpleStringProperty password = new SimpleStringProperty("");

    public Korisnik() {
    }

    public Korisnik(String imeIn, String  prezimeIn, String  emailIn, String  usernameIn, String  passwordIn) {
        this.ime = new SimpleStringProperty(imeIn);
        this.prezime = new SimpleStringProperty(prezimeIn);
        this.email = new SimpleStringProperty(emailIn);
        this.username = new SimpleStringProperty(usernameIn);
        this.password = new SimpleStringProperty(passwordIn);
    }

    //ime
    public String getIme() {
        return ime.get();
    }

    public SimpleStringProperty imeProperty() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime.set(ime);
    }


    //prezime
    public String getPrezime() {
        return prezime.get();
    }

    public SimpleStringProperty prezimeProperty() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime.set(prezime);
    }


    //email
    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }



    //username
    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }


    //password
    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    @Override
    public String toString() {
        String s = ime.get() + " " + prezime.get();
        return s;
    }
}
