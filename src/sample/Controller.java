package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Controller {

    public TextField prezimeFld;
    public TextField imeFld;
    public TextField passwordFld;
    public TextField emailFld;
    public TextField usernameFld;

    private KorisniciModel model;

    public  Controller (KorisniciModel m) {
        this.model = m;
    }

    @FXML
    public void initialize() {
        imeFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        usernameFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        passwordFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());
    }

    public void computerEndProgram(ActionEvent actionEvent) {
        Platform.exit();
    }
}




