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

    @FXML
    public void initialize() {

    }

    public void computerEndProgram(ActionEvent actionEvent) {
        Platform.exit();
    }
}




