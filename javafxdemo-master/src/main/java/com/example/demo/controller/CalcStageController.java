package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.data.DataSource;
import com.example.demo.view.SecStageView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class CalcStageController implements Initializable {

    @FXML
    private TextField zxzk;

    @FXML
    private Button xdrjz;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calcData();
    }

    public void calcData() {
    }

    @FXML
    void quitBtAction(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void xdrjzAction(ActionEvent event) {
        Stage stage = (Stage) xdrjz.getScene().getWindow();
        stage.close();
        DemoApplication.showView(SecStageView.class);
    }


}
