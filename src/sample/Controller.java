package sample;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class Controller {

    public TextField prezimeFld;
    public TextField imeFld;
    public TextField passwordFld;
    public TextField emailFld;
    public TextField usernameFld;
    public ListView korisniciList;

    private KorisniciModel model = new KorisniciModel();
    /*
    public  Controller (KorisniciModel m) {
        this.model = m;
    }*/

    @FXML
    public void initialize() {
        model.napuni();
        model.setTrenutniKorisnik(new Korisnik("Bakir", "Karovic", "bkarovic1@.etf.unsa.ba","bkarovic1", "nedam"));

        imeFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        usernameFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        passwordFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());
        korisniciList.setItems(model.getKorisnici());



        //listener
        korisniciList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnik, Korisnik t1) {
                model.setTrenutniKorisnik(t1);
            }
        });

    }

    public void computerEndProgram(ActionEvent actionEvent) {
        Platform.exit();
    }
}