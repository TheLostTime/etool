package com.example.demo.controller;

import com.example.demo.DemoApplication;
import com.example.demo.data.DataSource;
import com.example.demo.data.ParamBean;
import com.example.demo.view.CalcStageView;
import com.example.demo.view.InputStageView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class SecStageController implements Initializable {

    @FXML
    private ChoiceBox<?> dxxh;

    @FXML
    private TextField dxfls;

    @FXML
    private TextField dxizj;

    @FXML
    private TextField dxzldz;

    @FXML
    private TextField fljj;

    @FXML
    private TextField dddz;

    @FXML
    private TextField dddzl;

    @FXML
    private TextField dxzj;

    @FXML
    private TextField dxdz;

    @FXML
    private AnchorPane picAnchorPanel;

    @FXML
    private ImageView txImageView;

    @FXML
    private ChoiceBox<?> chooseLg;

    @FXML
    private TextField Glx;

    @FXML
    private TextField Gly;

    @FXML
    private ChoiceBox<?> chooseLa;

    @FXML
    private TextField Alx;

    @FXML
    private TextField Aly;

    @FXML
    private ChoiceBox<?> chooseLb;

    @FXML
    private TextField Blx;

    @FXML
    private TextField Bly;

    @FXML
    private ChoiceBox<?> chooseLc;

    @FXML
    private TextField Clx;

    @FXML
    private TextField Cly;

    @FXML
    private ChoiceBox<?> chooseA1;

    @FXML
    private TextField Arx;

    @FXML
    private TextField Ary;

    @FXML
    private ChoiceBox<?> chooseRg;

    @FXML
    private TextField Grx;

    @FXML
    private TextField Gry;

    @FXML
    private ChoiceBox<?> chooseB1;

    @FXML
    private TextField Brx;

    @FXML
    private TextField Bry;

    @FXML
    private ChoiceBox<?> chooseC1;

    @FXML
    private TextField Crx;

    @FXML
    private TextField Cry;

    @FXML
    private Button retInputBtn;

    @FXML
    private Button savePramBt;

    @FXML
    private Button startCalc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        drawPanePic("3.png");
    }

    public void drawPanePic(String picName){
        txImageView.setImage(new Image("image/" + picName));
        txImageView.setFitWidth(677);
        txImageView.setFitHeight(568);
        txImageView.setLayoutX(170);
        txImageView.setLayoutY(17);
    }

    public void drawPoint(int prefWidth,int prefHeight,int layX,int layY,String id) {
        TextField time = new TextField();
        time.setPrefHeight(prefHeight);
        time.setPrefWidth(prefWidth);
        time.setLayoutX(layX);
        time.setLayoutY(layY);
        time.setId(id);
        picAnchorPanel.getChildren().add(time);
    }



    @FXML
    void startCalcAction(ActionEvent event) {
        Stage stage = (Stage) startCalc.getScene().getWindow();
        stage.close();
        DemoApplication.showView(CalcStageView.class);
        CalcStageController controller = ApplicationContextProvider
                .getBean("calcStageController", CalcStageController.class);
        controller.calcData();
    }

    @FXML
    void retInputBtnAction(ActionEvent event) {
        Stage stage = (Stage) retInputBtn.getScene().getWindow();
        stage.close();
        DemoApplication.showView(InputStageView.class);
    }

    @FXML
    void savePramAction(ActionEvent event)   {
        // 保存数据
        ParamBean paramBean = DataSource.paramBean;
        // 弹框保存成功
        showAlertWindow("参数保存成功");
    }

    void showAlertWindow(String param) {
        Alert alert = new Alert( Alert.AlertType.NONE);
        alert.setTitle( "tip" );
        alert.setContentText(param);
        alert.initModality( Modality.NONE );
        ButtonType buttonTypeCancel = new ButtonType( "ok", ButtonBar.ButtonData.CANCEL_CLOSE );
        alert.getButtonTypes().setAll(buttonTypeCancel);
        alert.showAndWait();
    }
}
