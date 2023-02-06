package com.example.demo;

import com.example.demo.view.InputStageView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launchApp(DemoApplication.class, InputStageView.class, args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("参数输入");
        stage.getIcons().addAll(new Image("image/taskTitle.png"));
        super.start(stage);
    }
}
