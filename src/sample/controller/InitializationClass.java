package sample.controller;

import eu.hansolo.medusa.Gauge;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import org.controlsfx.control.NotificationPane;

public class InitializationClass {

    @FXML
    private Gauge gauge5;

    @FXML
    private Gauge gauge6;

    @FXML
    private Gauge gauge1;

    @FXML
    private Gauge gauge2;
    @FXML
    private Gauge gauge3;

    @FXML
    private Gauge gauge4;

    @FXML
    private ComboBox<String> IN1;

    @FXML
    private ComboBox<String> IN5;

    @FXML
    private ComboBox<String> IN4;

    @FXML
    private ComboBox<String> IN3;
    @FXML
    private NotificationPane Notify;
    @FXML
    private ComboBox<String> IN2;

    @FXML
    private ComboBox<String> IN6;

    @FXML
    private ComboBox<String> IN7;

    @FXML
    private Button cmd_set_param;

    @FXML
    private Button cmd_next1;

    @FXML
    private Tab downlink_tab;
    @FXML
    private Tab uplink_tab;

    @FXML
    private TextField A;

    @FXML
    private TextField B;

    @FXML
    private TextField H;

    @FXML
    private TextField G;

    @FXML
    private TextField C;

    @FXML
    private TextField I;

    @FXML
    private Button cmd_calculate_dl;

    @FXML
    private TextField D;

    @FXML
    private TextField E;

    @FXML
    private TextField J;

    @FXML
    private Pane gauge_display1;

    @FXML
    private Button cmd_save1;

    @FXML
    private Button cmd_update1;

    @FXML
    private Button cmd_next2;

    @FXML
    private Button cmd_calculate_ul;

    @FXML
    private TextField M;

    @FXML
    private TextField R;

    @FXML
    private TextField K;

    @FXML
    private TextField L;

    @FXML
    private TextField P;

    @FXML
    private TextField O;

    @FXML
    private TextField N;

    @FXML
    private TextField Q;

    @FXML
    private Button cmd_save2;

    @FXML
    private Button cmd_next3;

    @FXML
    private Button cmd_update2;

    @FXML
    private Pane gauge_display2;

    @FXML
    private ComboBox<String> IN8;

    @FXML
    private Pane gauge_display21;

    @FXML
    private Tab locate_site_map;

    @FXML
    private Tab budget_output;

    @FXML
    private TextField S;

    @FXML
    private TextField IN12;

    @FXML
    private TextField IN11;

    @FXML
    private TextField IN10;

    @FXML
    private TextField T;

    @FXML
    private TextField IN14;
    @FXML
    private Button cmd_update;

    @FXML
    private ComboBox<String> IN9;

    @FXML
    private ComboBox<String> IN13;

    @FXML
    private Pane gauge_display3;

    @FXML
    private Button cmd_calculate_result;

    @FXML
    private TextField O1;

    @FXML
    private TextField O2;

    @FXML
    private TextField O3;

    @FXML
    private Button cmd_save3;

    @FXML
    private Button cmd_update3;

    @FXML
    private Button cmd_view_plan;

    @FXML
    private Button cmd_report;
    @FXML
    private Label inserted;
    @FXML
    private Label data_saved1;
    @FXML
    private Label label2;
    @FXML
    private Label label33;
    @FXML
    private Gauge gaugex;
    @FXML
    private Label label22;

    @FXML
    private Gauge gauge7;

    @FXML
    private Gauge gauge8;

    @FXML
    private Gauge gauge9;

    @FXML
    private Gauge gauge10;

    @FXML
    private Gauge gauge11;

public void initialise4GIcons(){
    cmd_set_param.setGraphic(new ImageView("./sample/icons/ok.png"));
    cmd_update.setGraphic(new ImageView("./sample/icons/refresh.png"));
    cmd_calculate_dl.setGraphic(new ImageView("./sample/icons/icon_calc.png"));
    cmd_save1.setGraphic(new ImageView("./sample/icons/ok.png"));
    cmd_update1.setGraphic(new ImageView("./sample/icons/refresh.png"));
    cmd_calculate_ul.setGraphic(new ImageView("./sample/icons/icon_calc.png"));
    cmd_save2.setGraphic(new ImageView("./sample/icons/ok.png"));
    cmd_update2.setGraphic(new ImageView("./sample/icons/refresh.png"));
    cmd_calculate_result.setGraphic(new ImageView("./sample/icons/icon_calc.png"));
    cmd_save3.setGraphic(new ImageView("./sample/icons/ok.png"));
    cmd_update3.setGraphic(new ImageView("./sample/icons/refresh.png"));
}
}