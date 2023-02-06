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
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
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
//        InputStageController controller = ApplicationContextProvider
//                .getBean("inputStageController", InputStageController.class);
//        controller.initPic();
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

        // 导线参数输入
        if (!StringUtils.isEmpty(dxzj.getText())) {
            paramBean.setDxzj(BigDecimal.valueOf(Double.parseDouble(dxzj.getText())));
        }
        if (null != dxxh.getSelectionModel().getSelectedItem()) {
            paramBean.setDxxh(dxxh.getSelectionModel().getSelectedItem().toString());
        }
        if (!StringUtils.isEmpty(dxzldz.getText())) {
            paramBean.setDxzldz(BigDecimal.valueOf(Double.parseDouble(dxzldz.getText())));
        }
        if (null != dcfldsx.getSelectionModel().getSelectedItem()) {
            paramBean.setDcfldsx(dcfldsx.getSelectionModel().getSelectedItem().toString());
        }
        if (!StringUtils.isEmpty(fljj.getText())) {
            paramBean.setFljj(BigDecimal.valueOf(Double.parseDouble(fljj.getText())));
        }
        // 系统参数输入
        if (!StringUtils.isEmpty(xlssrl.getText())) {
            paramBean.setXlssrl(BigDecimal.valueOf(Double.parseDouble(xlssrl.getText())));
        }
        if (!StringUtils.isEmpty(xldydj.getText())) {
            paramBean.setXldydj(BigDecimal.valueOf(Double.parseDouble(xldydj.getText())));
        }
        if (!StringUtils.isEmpty(sdglys.getText())) {
            paramBean.setSdglys(BigDecimal.valueOf(Double.parseDouble(sdglys.getText())));
        }
        if (!StringUtils.isEmpty(xtpl.getText())) {
            paramBean.setXtpl(BigDecimal.valueOf(Double.parseDouble(xtpl.getText())));
        }
        if (!StringUtils.isEmpty(xtpl.getText())) {
            paramBean.setXtpl(BigDecimal.valueOf(Double.parseDouble(xtpl.getText())));
        }
        if (!StringUtils.isEmpty(yhfxdzk.getText())) {
            paramBean.setYhfxdzk(BigDecimal.valueOf(Double.parseDouble(yhfxdzk.getText())));
        }
        if (!StringUtils.isEmpty(yhlxdzk.getText())) {
            paramBean.setYhlxdzk(BigDecimal.valueOf(Double.parseDouble(yhlxdzk.getText())));
        }
        if (!StringUtils.isEmpty(ehfxdzk.getText())) {
            paramBean.setEhfxdzk(BigDecimal.valueOf(Double.parseDouble(ehfxdzk.getText())));
        }
        if (!StringUtils.isEmpty(ehlxdzk.getText())) {
            paramBean.setEhlxdzk(BigDecimal.valueOf(Double.parseDouble(ehlxdzk.getText())));
        }
        if (!StringUtils.isEmpty(dddz.getText())) {
            paramBean.setDddz(BigDecimal.valueOf(Double.parseDouble(dddz.getText())));
        }
        if (!StringUtils.isEmpty(dddzl.getText())) {
            paramBean.setDddzl(BigDecimal.valueOf(Double.parseDouble(dddzl.getText())));
        }
        if (!StringUtils.isEmpty(hjwd.getText())) {
            paramBean.setHjwd(BigDecimal.valueOf(Double.parseDouble(hjwd.getText())));
        }
        if (!StringUtils.isEmpty(zkcdl.getText())) {
            paramBean.setZkcdl(BigDecimal.valueOf(Double.parseDouble(zkcdl.getText())));
        }
        if (!StringUtils.isEmpty(dxydzjl.getText())) {
            paramBean.setDxydzjl(BigDecimal.valueOf(Double.parseDouble(dxydzjl.getText())));
        }
        if (!StringUtils.isEmpty(dxedzjl.getText())) {
            paramBean.setDxedzjl(BigDecimal.valueOf(Double.parseDouble(dxedzjl.getText())));
        }
        if (!StringUtils.isEmpty(dxsdzjl.getText())) {
            paramBean.setDxsdzjl(BigDecimal.valueOf(Double.parseDouble(dxsdzjl.getText())));
        }
        if (!StringUtils.isEmpty(dxsidzjl.getText())) {
            paramBean.setDxsidzjl(BigDecimal.valueOf(Double.parseDouble(dxsidzjl.getText())));
        }
        if (!StringUtils.isEmpty(dxwdzjl.getText())) {
            paramBean.setDxwdzjl(BigDecimal.valueOf(Double.parseDouble(dxwdzjl.getText())));
        }
        if (!StringUtils.isEmpty(dxldzjl.getText())) {
            paramBean.setDxldzjl(BigDecimal.valueOf(Double.parseDouble(dxldzjl.getText())));
        }
        if (!StringUtils.isEmpty(dxyddjl.getText())) {
            paramBean.setDxyddjl(BigDecimal.valueOf(Double.parseDouble(dxyddjl.getText())));
        }
        if (!StringUtils.isEmpty(dxeddjl.getText())) {
            paramBean.setDxeddjl(BigDecimal.valueOf(Double.parseDouble(dxeddjl.getText())));
        }
        if (!StringUtils.isEmpty(dxsddjl.getText())) {
            paramBean.setDxsddjl(BigDecimal.valueOf(Double.parseDouble(dxsddjl.getText())));
        }
        if (!StringUtils.isEmpty(dxsiddjl.getText())) {
            paramBean.setDxsiddjl(BigDecimal.valueOf(Double.parseDouble(dxsiddjl.getText())));
        }
        if (!StringUtils.isEmpty(dxwddjl.getText())) {
            paramBean.setDxwddjl(BigDecimal.valueOf(Double.parseDouble(dxwddjl.getText())));
        }
        if (!StringUtils.isEmpty(dxlddjl.getText())) {
            paramBean.setDxlddjl(BigDecimal.valueOf(Double.parseDouble(dxlddjl.getText())));
        }
        if (null != line_selection1.getSelectedToggle()) {
            paramBean.setRadioy(((RadioButton)line_selection1.getSelectedToggle()).getText());
        }
        if (null != line_selection2.getSelectedToggle()) {
            paramBean.setRadioe(((RadioButton)line_selection2.getSelectedToggle()).getText());
        }
        if (null != line_selection3.getSelectedToggle()) {
            paramBean.setRadios(((RadioButton)line_selection3.getSelectedToggle()).getText());
        }
        if (null != line_selection4.getSelectedToggle()) {
            paramBean.setRadiosi(((RadioButton)line_selection4.getSelectedToggle()).getText());
        }
        if (null != line_selection5.getSelectedToggle()) {
            paramBean.setRadiow(((RadioButton)line_selection5.getSelectedToggle()).getText());
        }
        if (null != line_selection6.getSelectedToggle()) {
            paramBean.setRadiol(((RadioButton)line_selection6.getSelectedToggle()).getText());
        }
        if (null != line_selection6.getSelectedToggle()) {
            paramBean.setRadiol(((RadioButton)line_selection6.getSelectedToggle()).getText());
        }
        // 地线1对地距离
        if (!StringUtils.isEmpty(dixyddjl.getText())) {
            paramBean.setDixyddjl(BigDecimal.valueOf(Double.parseDouble(dixyddjl.getText())));
        }
        if (!StringUtils.isEmpty(dixeddjl.getText())) {
            paramBean.setDixeddjl(BigDecimal.valueOf(Double.parseDouble(dixeddjl.getText())));
        }
        if (!StringUtils.isEmpty(dixydzjl.getText())) {
            paramBean.setDixydzjl(BigDecimal.valueOf(Double.parseDouble(dixydzjl.getText())));
        }
        if (!StringUtils.isEmpty(dixedzjl.getText())) {
            paramBean.setDixedzjl(BigDecimal.valueOf(Double.parseDouble(dixedzjl.getText())));
        }
        if (null != line_selection7.getSelectedToggle()) {
            paramBean.setDxz(((RadioButton)line_selection7.getSelectedToggle()).getText());
        }
        if (null != line_selection8.getSelectedToggle()) {
            paramBean.setDxy(((RadioButton)line_selection8.getSelectedToggle()).getText());
        }
        // 地线1直径
        if (!StringUtils.isEmpty(dxyzj.getText())) {
            paramBean.setDxyzj(BigDecimal.valueOf(Double.parseDouble(dxyzj.getText())));
        }
        if (null != dxyxh.getSelectionModel().getSelectedItem()) {
            paramBean.setDxyxh(dxyxh.getSelectionModel().getSelectedItem().toString());
        }
        if (!StringUtils.isEmpty(dxyzldz.getText())) {
            paramBean.setDxyzldz(BigDecimal.valueOf(Double.parseDouble(dxyzldz.getText())));
        }
        if (!StringUtils.isEmpty(dxewj.getText())) {
            paramBean.setDxewj(BigDecimal.valueOf(Double.parseDouble(dxewj.getText())));
        }
        if (null != dxexh.getSelectionModel().getSelectedItem()) {
            paramBean.setDxexh(dxexh.getSelectionModel().getSelectedItem().toString());
        }
        if (!StringUtils.isEmpty(dxezldz.getText())) {
            paramBean.setDxezldz(BigDecimal.valueOf(Double.parseDouble(dxezldz.getText())));
        }
        // 换位参数

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
