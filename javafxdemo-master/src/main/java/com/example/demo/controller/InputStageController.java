package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.DemoApplication;
import com.example.demo.util.ReadExcelUtils;
import com.example.demo.view.JkxlpzxxView;
import com.example.demo.view.SecStageView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
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
    private TextField jkxlfls;

    @FXML
    private ChoiceBox<?> jkxlxh;

    @FXML
    private TextField jkxlcd;

    @FXML
    private ChoiceBox<?> jkxlsdxfs;

    @FXML
    private ChoiceBox<?> dlxlxh;

    @FXML
    private TextField dlxlcd;

    @FXML
    private Button jkxlpzxx;

    @FXML
    private Button dlxlpzxx;

    @FXML
    private Button InputSure;

    @FXML
    private Button inputQuit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

        // 重开页面
        Stage stage = (Stage) InputSure.getScene().getWindow();
        stage.getScene();
        stage.close();
        DemoApplication.showView(SecStageView.class);
    }

    @FXML
    void inputQuitAction(ActionEvent event) {
        System.exit(0);
    }


    /**
     * 打开并获取架空线路配置信息
     * @param event
     */
    @FXML
    void getJkxlpzxx(ActionEvent event) throws IOException {
        Stage messageBoxStage = new Stage();
        AnchorPane page = (AnchorPane) FXMLLoader.load(
                JkxlpzxxController.class.getResource("/view/Jkxlpzxx.fxml"));
        Scene scene = new Scene(page);
        messageBoxStage.setScene(scene);
        messageBoxStage.setTitle("配置");
        Stage stage = (Stage) InputSure.getScene().getWindow();
        messageBoxStage.initOwner(stage);
        messageBoxStage.initModality(Modality.WINDOW_MODAL);

        // TODO 初始化赋值配置信息


        messageBoxStage.show();
    }

}
