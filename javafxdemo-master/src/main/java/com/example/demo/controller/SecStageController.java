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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class SecStageController implements Initializable {

    @FXML
    private TextField dxzj;

    @FXML
    private ChoiceBox<?> dxxh;

    @FXML
    private TextField dxzldz;

    @FXML
    private ChoiceBox<?> dcfldsx;

    @FXML
    private TextField fljj;

    @FXML
    private TextField xlssrl;

    @FXML
    private TextField xldydj;

    @FXML
    private TextField sdglys;

    @FXML
    private TextField xtpl;

    @FXML
    private TextField yhfxdzk;

    @FXML
    private TextField yhlxdzk;

    @FXML
    private TextField ehfxdzk;

    @FXML
    private TextField ehlxdzk;

    @FXML
    private TextField dddz;

    @FXML
    private TextField dddzl;

    @FXML
    private TextField hjwd;

    @FXML
    private TextField zkcdl;

    @FXML
    private AnchorPane picAnchorPaneSec;

    @FXML
    private TextField dxydzjl;

    @FXML
    private TextField dxedzjl;

    @FXML
    private TextField dxsdzjl;

    @FXML
    private TextField dxsidzjl;

    @FXML
    private TextField dxwdzjl;

    @FXML
    private TextField dxldzjl;

    @FXML
    private TextField dxyddjl;

    @FXML
    private TextField dxeddjl;

    @FXML
    private TextField dxsddjl;

    @FXML
    private TextField dxsiddjl;

    @FXML
    private TextField dxwddjl;

    @FXML
    private TextField dxlddjl;

    @FXML
    private RadioButton radiozy;

    @FXML
    private ToggleGroup line_selection1;

    @FXML
    private RadioButton radioyy;

    @FXML
    private RadioButton radioze;

    @FXML
    private ToggleGroup line_selection2;

    @FXML
    private RadioButton radioye;

    @FXML
    private RadioButton radiozs;

    @FXML
    private ToggleGroup line_selection3;

    @FXML
    private RadioButton radioys;

    @FXML
    private RadioButton radiozsi;

    @FXML
    private ToggleGroup line_selection4;

    @FXML
    private RadioButton radioysi;

    @FXML
    private RadioButton radiozw;

    @FXML
    private ToggleGroup line_selection5;

    @FXML
    private RadioButton radioyw;

    @FXML
    private RadioButton radiozl;

    @FXML
    private ToggleGroup line_selection6;

    @FXML
    private RadioButton radioyl;

    @FXML
    private RadioButton dxzy;

    @FXML
    private ToggleGroup line_selection7;

    @FXML
    private RadioButton dxyy;

    @FXML
    private RadioButton dxze;

    @FXML
    private ToggleGroup line_selection8;

    @FXML
    private TextField dixyddjl;

    @FXML
    private TextField dixydzjl;

    @FXML
    private TextField dixeddjl;

    @FXML
    private TextField dixedzjl;

    @FXML
    private RadioButton dxye;

    @FXML
    private Button refreshPicBtn;

    @FXML
    private TextField dxyzj;

    @FXML
    private ChoiceBox<?> dxyxh;

    @FXML
    private ChoiceBox<?> dxexh;

    @FXML
    private TextField dxyzldz;

    @FXML
    private TextField dxewj;

    @FXML
    private TextField dxezldz;

    @FXML
    private RadioButton bhwqk;

    @FXML
    private ToggleGroup radiohwcsGroup;

    @FXML
    private ChoiceBox<?> bhwyh;

    @FXML
    private ChoiceBox<?> bhweh;

    @FXML
    private TextField bhwcd;

    @FXML
    private RadioButton hwqk;

    @FXML
    private TextField hwydcd;

    @FXML
    private TextField hwedcd;

    @FXML
    private TextField hwsdcd;

    @FXML
    private ChoiceBox<?> hwydyh;

    @FXML
    private ChoiceBox<?> hwedyh;

    @FXML
    private ChoiceBox<?> hwsdyh;

    @FXML
    private ChoiceBox<?> hwydeh;

    @FXML
    private ChoiceBox<?> hwedeh;

    @FXML
    private ChoiceBox<?> hwsdeh;

    @FXML
    private ChoiceBox<?> sfxz;

    @FXML
    private Button retInputBtn;

    @FXML
    private Button savePramBt;

    @FXML
    private Button startCalc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

        //初始化首页图片
        TitledPane originTitledPane = (TitledPane) stage.getScene().getRoot().getChildrenUnmodifiable().get(1);
        Pane originTitleSkinPane = (Pane)originTitledPane.getChildrenUnmodifiable().get(0);
        AnchorPane originAnchorPane = (AnchorPane)((Pane)originTitleSkinPane.getChildren().get(0)).getChildren().get(3);
        originAnchorPane.getChildren().addAll(DataSource.AnchorPaneMap.get("picAnchorPanel").getChildren());
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
