package com.example.demo.controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class JkxlpzxxController implements Initializable {

    @FXML
    private TextField jkpzdxxh;

    @FXML
    private TextField jkpzdxzj;

    @FXML
    private TextField jkpzdxzldz;

    @FXML
    private TextField jkpzdxfls;

    @FXML
    private TextField jkpzfljj;

    @FXML
    private TextField jkpzdddz;

    @FXML
    private TextField jkpzdddzl;

    @FXML
    private Button jkxlpzgb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void cloesJkxlpzgb(ActionEvent event) {
        Stage stage = (Stage) jkxlpzgb.getScene().getWindow();
        stage.close();
    }

}
