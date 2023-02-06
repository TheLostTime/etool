package com.example.demo.data;

import javafx.scene.layout.AnchorPane;

import java.util.HashMap;
import java.util.Map;

public interface DataSource {

    Map<String, AnchorPane> AnchorPaneMap = new HashMap<>();

    ParamBean paramBean = new ParamBean();

}
