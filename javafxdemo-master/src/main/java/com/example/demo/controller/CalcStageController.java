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
    private TextField fxzk;

    @FXML
    private TextField lxzk;

    @FXML
    private TextField zxdr;

    @FXML
    private TextField fxdr;

    @FXML
    private TextField lxdr;

    @FXML
    private TextField txzxzk;

    @FXML
    private TextField fxzxzk;

    @FXML
    private TextField txfxzk;

    @FXML
    private TextField fxfxzk;

    @FXML
    private TextField txlxzk;

    @FXML
    private TextField fxlxzk;

    @FXML
    private TextField yhxlfxbphs;

    @FXML
    private TextField yhxllxbphs;

    @FXML
    private TextField ehxlfxbphs;

    @FXML
    private TextField ehxllxbphs;

    @FXML
    private TextField zxxlfxbphs;

    @FXML
    private TextField zxxllxbphs;

    @FXML
    private Button zkjz;

    @FXML
    private Button drjz;

    @FXML
    private Button xzkjz;

    @FXML
    private Button xdrjz;

    @FXML
    private Button jgbc;

    @FXML
    private Button quitBt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        calcData();
    }

    public void calcData() {
        zxzk.setText(DataSource.paramBean.getDxzj() == null ? "" : DataSource.paramBean.getDxzj().toString());
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
