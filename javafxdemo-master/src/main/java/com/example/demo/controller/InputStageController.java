package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.DemoApplication;
import com.example.demo.data.DataSource;
import com.example.demo.util.ReadExcelUtils;
import com.example.demo.view.SecStageView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class InputStageController implements Initializable {
    @FXML
    private TextField filePathArea;

    @FXML
    private Button chooseFile;

    @FXML
    private Button InputSure;

//    @FXML
//    private ImageView firstImage;

    @FXML
    private AnchorPane picAnchorPanel;

    @FXML
    private TitledPane picTitlePane;

    @FXML
    private RadioButton txRadio1;

    @FXML
    private RadioButton txRadio2;

    @FXML
    private RadioButton txRadio3;

    @FXML
    private RadioButton txRadio4;

    @FXML
    private RadioButton txRadio5;

    @FXML
    private Button inputQuit;

    @FXML
    private ToggleGroup taxing_selection;

    @FXML
    private TextField projectName;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txRadio5.setSelected(true);
        drawPanePic("1.png");
    }

    public void drawPanePic(String picName){
        picAnchorPanel.getChildren().clear();
        ImageView imageView = new ImageView(new Image("image/" + picName));
        imageView.setFitHeight(416);
        imageView.setFitWidth(328);
        imageView.setLayoutY(-7.0);
        picAnchorPanel.getChildren().add(imageView);
        //画图片的标注点
        if (picName.equals("1.png")) {
            drawPoint(33,30,26,14,"txText1");
            drawPoint(33,30,61,36,"txText2");
            drawPoint(33,30,221,36,"txText3");
            drawPoint(33,30,261,21,"txText4");
            drawPoint(33,30,14,112,"txText5");
            drawPoint(33,30,268,112,"txText6");
            drawPoint(33,30,45,175,"txText7");
            drawPoint(33,30,239,175,"txText8");
        }
        if (picName.equals("2.png")) {
            drawPoint(33,30,14,53,"txText1");
            drawPoint(33,30,273,53,"txText2");
            drawPoint(33,30,49,130,"txText3");
            drawPoint(33,30,238,130,"txText4");
        }
        DataSource.AnchorPaneMap.put("picAnchorPanel",picAnchorPanel);
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

    /**
     * 弹出塔型选择
     * @param event
     * @throws IOException
     */
    @FXML
    void showTxChoose(MouseEvent event) throws IOException {
        Stage messageBoxStage = new Stage();
        AnchorPane page = (AnchorPane) FXMLLoader.load(
                TxController.class.getResource("/view/Tx.fxml"));
        Scene scene = new Scene(page);
        messageBoxStage.setScene(scene);
        messageBoxStage.setTitle("选择塔型");
        Stage stage = (Stage) InputSure.getScene().getWindow();
        messageBoxStage.initOwner(stage);
        messageBoxStage.initModality(Modality.WINDOW_MODAL);

        RadioButton radioButton = (RadioButton)event.getSource();
        if (radioButton.getText().equals("双回路双地线")) {
            ToggleGroup group = new ToggleGroup();

            Image image = new Image("image/1.png");
            RadioButton rb = new RadioButton();
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(157);
            imageView.setFitHeight(200);
            rb.setGraphic(imageView);
            rb.setLayoutX(49);
            rb.setLayoutY(87);
            rb.setUserData("1.png");
            rb.setToggleGroup(group);
            rb.setId("firstChooseBtn");
            page.getChildren().add(rb);

            Image image2 = new Image("image/2.png");
            RadioButton rb2 = new RadioButton();
            ImageView imageView2 = new ImageView(image2);
            imageView2.setFitWidth(157);
            imageView2.setFitHeight(200);
            rb2.setGraphic(imageView2);
            rb2.setLayoutX(236);
            rb2.setLayoutY(87);
            rb2.setToggleGroup(group);
            rb2.setUserData("2.png");
            page.getChildren().add(rb2);
        }

        messageBoxStage.show();
    }


    @FXML
    void selectExcel(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("选择Excel文件");
        Stage selectFile = new Stage();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Excel", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLS", "*.xls"), new FileChooser.ExtensionFilter("XLSX", "*.xlsx"));
        File file = fileChooser.showOpenDialog(selectFile);
        if (file != null) {
            try {
                filePathArea.appendText(file.getAbsolutePath());
                ReadExcelUtils excelUtils = new ReadExcelUtils(file.getAbsolutePath());
                System.out.println(JSON.toJSONString(excelUtils.readExcelTitle()));
                System.out.println("结束......");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void InputSureAction(ActionEvent event) {
        // 获取页面数据
        DataSource.paramBean.setFilePathArea(filePathArea.getText());
        DataSource.paramBean.setProjectName(projectName.getText());
        DataSource.paramBean.setTxRadioChooseText(
                ((RadioButton)taxing_selection.getSelectedToggle()).getText());

        // 页面切换时对象的引用会被销毁，此时需要重置对象
        if (DataSource.AnchorPaneMap.get("picAnchorPanel").getChildren().size() == 0) {
            DataSource.AnchorPaneMap.put("picAnchorPanel",picAnchorPanel);
        }

        // 重开页面
        Stage stage = (Stage) InputSure.getScene().getWindow();
        stage.getScene();
        stage.close();
        DemoApplication.showView(SecStageView.class);

        // 返回时不调用下一个页面初始化方法，手动重写
        Pane Pane1 = (Pane) ((TitledPane)((HBox)stage.getScene().getRoot().getChildrenUnmodifiable().get(1))
                .getChildren().get(0)).getChildrenUnmodifiable().get(0);
        AnchorPane picAnchorPaneSec = (AnchorPane)((Pane)Pane1.getChildren().get(0)).getChildren().get(0);
        picAnchorPaneSec.getChildren().addAll(DataSource.AnchorPaneMap.get("picAnchorPanel").getChildren());
        DataSource.AnchorPaneMap.put("picAnchorPanel",picAnchorPaneSec);
    }

    @FXML
    void inputQuitAction(ActionEvent event) {
        System.exit(0);
    }

}
