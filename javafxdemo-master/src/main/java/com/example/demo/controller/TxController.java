package com.example.demo.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class TxController implements Initializable {

    @FXML
    private Button makeSureChooseId;

    @FXML
    private Button cancelChooseId;

    @FXML
    private AnchorPane txChoosePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void cancelChoose(ActionEvent event) {
        Stage stage = (Stage) cancelChooseId.getScene().getWindow();
        stage.close();
    }

    @FXML
    void makeSureChoose(ActionEvent event) {
        Stage stage = (Stage) cancelChooseId.getScene().getWindow();
        stage.close();
    }
}
