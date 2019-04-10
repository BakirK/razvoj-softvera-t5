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
        model.setTrenutniKorisnik(model.getKorisnici().get(0));
        setTextPropetryBind();
        korisniciList.setItems(model.getKorisnici());
        System.out.println("initialize");

        // TODO: postavit default selected item na prvi da ne moram klikat uvjek
        // TODO: promjenit fokus na novi korisnik kad kliknem Dodaj u list view
        // TODO: promjena elemenata strelicama treba pozvati metodu setCurrentUser
        //listener
        korisniciList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnikOld, Korisnik korisnikNew) {
                if (korisnikOld != null) {
                    setTextPropetryUnBind();
                    System.out.println("old null");
                }
                if (korisnikNew == null) {
                    System.out.println("new null");
                    imeFld.setText("");
                    prezimeFld.setText("");
                    emailFld.setText("");
                    usernameFld.setText("");
                    passwordFld.setText("");
                }
                else {
                    //setTextPropetryBind();
                    System.out.println("else");
                }
                korisniciList.refresh();
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
        setTextPropetryUnBind();
        model.setTrenutniKorisnik(k);
        setTextPropetryBind();
        korisniciList.refresh();
    }

    @FXML
    private void addUser(ActionEvent mouseEvent) {
        model.addUser();
        setTextPropetryUnBind();
        model.setTrenutniKorisnik(model.getKorisnici().get(model.getKorisnici().size() - 1));
        //korisniciList.scrollTo(2);   //neradi iz nekog raloga
        //korisniciList.getFocusModel().focus(korisniciList.getFocusModel().focusNext());
        setTextPropetryBind();
        korisniciList.refresh();
    }
}