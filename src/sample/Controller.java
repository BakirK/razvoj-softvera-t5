package sample;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class Controller {

    private KorisniciModel model;
    public  Controller (KorisniciModel m) {
        model = m;
    }

    public TextField prezimeFld;
    public TextField imeFld;
    public TextField passwordFld;
    public TextField emailFld;
    public TextField usernameFld;
    public ListView korisniciList;



    @FXML
    public void initialize() {
        model.setTrenutniKorisnik(new Korisnik("Bakir", "Karovic", "bkarovic1@.etf.unsa.ba","bkarovic1", "nedam"));
        setTextPropetryBind();
        korisniciList.setItems(model.getKorisnici());



        //listener
        korisniciList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnikOld, Korisnik korisnikNew) {
                if (korisnikNew == null) {
                    System.out.println("new null");
                    imeFld.setText("");
                    prezimeFld.setText("");
                    emailFld.setText("");
                    usernameFld.setText("");
                    passwordFld.setText("");
                }
                else {
                    setTextPropetryBind();
                }
                if (korisnikOld != null) {
                    setTextPropetryUnBind();
                    System.out.println("old null");
                }
            }
        });

    }

    private void setTextPropetryBind() {

        imeFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        usernameFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().emailProperty());
        passwordFld.textProperty().bindBidirectional(model.getTrenutniKorisnik().passwordProperty());
    }

    private void setTextPropetryUnBind() {
        imeFld.textProperty().unbindBidirectional(model.getTrenutniKorisnik().imeProperty());
        prezimeFld.textProperty().unbindBidirectional(model.getTrenutniKorisnik().prezimeProperty());
        emailFld.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
        usernameFld.textProperty().unbindBidirectional(model.getTrenutniKorisnik().emailProperty());
        passwordFld.textProperty().unbindBidirectional(model.getTrenutniKorisnik().passwordProperty());
    }



    public void computerEndProgram(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    private void setCurrentUser(MouseEvent mouseEvent) {
        Korisnik k = (Korisnik) korisniciList.getSelectionModel().getSelectedItem();
        model.setTrenutniKorisnik(k);
    }

    @FXML
    private void addUser(ActionEvent mouseEvent) {
        model.addUser();
        model.setTrenutniKorisnik(new Korisnik());
        setTextPropetryBind();
    }
}