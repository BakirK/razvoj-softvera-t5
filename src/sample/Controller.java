package sample;


import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
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
        korisniciList.requestFocus();
        model.setTrenutniKorisnik(model.getKorisnici().get(0));
        setTextPropetryBind();
        korisniciList.setItems(model.getKorisnici());
        korisniciList.getFocusModel().focus(0);
        //System.out.println("initialize");

        //listener
        korisniciList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Korisnik>() {
            @Override
            public void changed(ObservableValue<? extends Korisnik> observableValue, Korisnik korisnikOld, Korisnik korisnikNew) {
                if (korisnikOld != null) {
                    setTextPropetryUnBind();
                    //System.out.println("old null");
                }
                if (korisnikNew == null) {
                    //System.out.println("new null");
                    imeFld.setText("");
                    prezimeFld.setText("");
                    emailFld.setText("");
                    usernameFld.setText("");
                    passwordFld.setText("");
                }
                else {
                    //setTextPropetryBind();
                    //System.out.println("else");
                    updateSelectedUser();
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


    //not a Star Trek reference at all
    public void computerEndProgram(ActionEvent actionEvent) {
        Platform.exit();
    }


    @FXML
    private void setCurrentUser(MouseEvent mouseEvent) {
    }

    @FXML
    private void addUser(ActionEvent mouseEvent) {
        model.addUser();
        setTextPropetryUnBind();
        model.setTrenutniKorisnik(model.getKorisnici().get(model.getKorisnici().size() - 1));
        setTextPropetryBind();
        korisniciList.refresh();
        korisniciList.requestFocus();
        //korisniciList.getFocusModel().focus(model.getKorisnici().size() - 1);
        korisniciList.getSelectionModel().selectLast();

    }

    @FXML
    private void handle(KeyEvent event) {
        //System.out.println(event.getCode());
        if (event.getCode().isArrowKey()) {
            updateSelectedUser();
        }
        else if (event.getCode() == KeyCode.ESCAPE) {
            Platform.exit();
        }
    }

    private void updateSelectedUser() {
        Korisnik k = (Korisnik) korisniciList.getSelectionModel().getSelectedItem();
        setTextPropetryUnBind();
        model.setTrenutniKorisnik(k);
        setTextPropetryBind();
        korisniciList.refresh();
    }
}