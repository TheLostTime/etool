package com.example.demo.data;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ParamBean {

    // 选择路径地址
    private String filePathArea;

    // 工程名称
    private String projectName;

    // 塔型单选值
    private String txRadioChooseText;

    // 导线直径
    private BigDecimal dxzj;

    // 导线型号
    private String dxxh;

    // 导线直流电阻
    private BigDecimal dxzldz;

    // 对称分裂导数线
    private String dcfldsx;


    private BigDecimal fljj;


    // 线路输送容量
    private BigDecimal xlssrl;


    private BigDecimal xldydj;


    private BigDecimal sdglys;


    private BigDecimal xtpl;


    private BigDecimal yhfxdzk;


    private BigDecimal yhlxdzk;


    private BigDecimal ehfxdzk;


    private BigDecimal ehlxdzk;


    private BigDecimal dddz;


    private BigDecimal dddzl;


    private BigDecimal hjwd;

    private BigDecimal zkcdl;

    // 导线1对轴距离
    private BigDecimal dxydzjl;

    private BigDecimal dxedzjl;

    private BigDecimal dxsdzjl;

    private BigDecimal dxsidzjl;

    private BigDecimal dxwdzjl;

    private BigDecimal dxldzjl;

    private BigDecimal dxyddjl;

    private BigDecimal dxeddjl;

    private BigDecimal dxsddjl;

    private BigDecimal dxsiddjl;

    private BigDecimal dxwddjl;

    // 导线6对地距离
    private BigDecimal dxlddjl;

    // 导线1单选框
    private String radioy;

    private String radioe;

    private String radios;

    private String radiosi;

    private String radiow;

    // 导线6单选框
    private String radiol;

    // 地线1对地距离
    private BigDecimal dixyddjl;

    private BigDecimal dixydzjl;

    private BigDecimal dixeddjl;

    private BigDecimal dixedzjl;

    private String dxz;

    private String dxy;

    // 地线1直径
    private BigDecimal dxyzj;

    private String dxyxh;

    private String dxexh;


    private BigDecimal dxyzldz;


    private BigDecimal dxewj;


    private BigDecimal dxezldz;


    private RadioButton bhwqk;


    private ToggleGroup radiohwcsGroup;


    private ChoiceBox<?> bhwyh;


    private ChoiceBox<?> bhweh;


    private String bhwcd;


    private RadioButton hwqk;


    private String hwydcd;


    private String hwedcd;


    private String hwsdcd;


    private ChoiceBox<?> hwydyh;


    private ChoiceBox<?> hwedyh;


    private ChoiceBox<?> hwsdyh;


    private ChoiceBox<?> hwydeh;


    private ChoiceBox<?> hwedeh;


    private ChoiceBox<?> hwsdeh;


    private ChoiceBox<?> sfxz;


    private Button retInputBtn;


    private Button savePramBt;


    private Button startCalc;


    private String zxzk;


    private String fxzk;


    private String lxzk;


    private String zxdr;


    private String fxdr;


    private String lxdr;


    private String txzxzk;


    private String fxzxzk;


    private String txfxzk;


    private String fxfxzk;


    private String txlxzk;


    private String fxlxzk;


    private String yhxlfxbphs;


    private String yhxllxbphs;


    private String ehxlfxbphs;


    private String ehxllxbphs;


    private String zxxlfxbphs;


    private String zxxllxbphs;


    private Button zkjz;


    private Button drjz;


    private Button xzkjz;


    private Button xdrjz;


    private Button jgbc;


    private Button quitBt;



}
