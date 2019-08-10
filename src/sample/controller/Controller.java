package sample.controller;

import com.jfoenix.controls.JFXButton;
import eu.hansolo.medusa.Gauge;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.MaskerPane;
import org.controlsfx.control.NotificationPane;
import sample.model.Model;
import sample.model.ProjectModel;

import javax.swing.text.Style;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {
   Model model = new Model();
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
    private Label inserted;

    @FXML
    private Button cmd_update;

    @FXML
    private TextField A;

    @FXML
    private TextField B;

    @FXML
    private TextField C;

    @FXML
    private TextField G;

    @FXML
    private TextField H;

    @FXML
    private TextField I;

    @FXML
    private TextField D;

    @FXML
    private TextField E;

    @FXML
    private TextField J;

    @FXML
    private Button cmd_calculate_dl;

    @FXML
    private Button cmd_save1;

    @FXML
    private Button cmd_update1;

    @FXML
    private Label label2;

    @FXML
    private Gauge gauge1;

    @FXML
    private Gauge gauge2;

    @FXML
    private TextField K;

    @FXML
    private TextField L;

    @FXML
    private TextField N;

    @FXML
    private TextField O;

    @FXML
    private TextField P;

    @FXML
    private ComboBox<String> IN8;

    @FXML
    private TextField Q;

    @FXML
    private TextField M;

    @FXML
    private TextField R;

    @FXML
    private Button cmd_calculate_ul;

    @FXML
    private Button cmd_save2;

    @FXML
    private Button cmd_update2;

    @FXML
    private Label label22;

    @FXML
    private Gauge gauge3;

    @FXML
    private Gauge gauge4;

    @FXML
    private TextField S;

    @FXML
    private TextField T;

    @FXML
    private TextField IN12;

    @FXML
    private TextField IN10;

    @FXML
    private TextField IN11;

    @FXML
    private ComboBox<String> IN9;

    @FXML
    private ComboBox<String> IN13;

    @FXML
    private TextField IN14;

    @FXML
    private TextField O1;

    @FXML
    private TextField O2;

    @FXML
    private TextField O3;

    @FXML
    private Button cmd_calculate_result;

    @FXML
    private Button cmd_update3;

    @FXML
    private Button cmd_save3;

    @FXML
    private Label label33;

    @FXML
    private Gauge gauge5;

    @FXML
    private Gauge gauge6;

    @FXML
    private Gauge gauge7;

    @FXML
    private Gauge gauge8;

    @FXML
    private Gauge gauge9;

    @FXML
    private Gauge gauge11;
    @FXML
    private JFXButton cmd_create_project;
    @FXML
    private AnchorPane create_anchorePane;
    @FXML
    private Tab coverage_tab;

    @FXML
    private Tab display_sites_tab;
    @FXML
    private TextField txt_project_name;

    @FXML
    private Tab capacity_tab;

    @FXML
    private Tab report_tab;
    @FXML
    private Pane pane1;
    @FXML
    private WebView GoogleMap;
    @FXML
    private Button cmd_loadmap;
    @FXML
    private MaskerPane loadingmap;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(new ProjectModel().getProject() == null){
        coverage_tab.disableProperty().setValue(true);
        pane1.setVisible(false);
           display_sites_tab.disableProperty().setValue(true);
           capacity_tab.disableProperty().setValue(true);
           report_tab.disableProperty().setValue(true);

       }else{

       }
        //loadingmap.setVisible(true);
    }

    public void createProjects() {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../views/project_create.fxml"));
            Scene scene = new Scene(root);
            Stage nStage = new Stage();
            nStage.initModality(Modality.APPLICATION_MODAL);
            nStage.setScene(scene);
            //nStage.setMaximized(true);
            nStage.getIcons().add(new Image("./sample/icons/antenna_marker1.png"));
            nStage.setTitle("select network generation");
            nStage.show();

            Stage stage = (Stage) cmd_create_project.getScene().getWindow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCoverage(ActionEvent event){
        if(ProjectModel.gen.equals("2G/GSM NETWORK")){
            try {

                Parent root = null;
                //TODO check if project instance is null
                root = (Parent)new FXMLLoader().load(getClass().getResource("../views/Budget_GSM.fxml"));
                // lteicons.initialise4GIcons();
                Scene scene = new Scene(root);
                Stage nnstage = new Stage();
                nnstage.getIcons().add(new Image("./sample/icons/antenna_marker1.png"));
                nnstage.initModality(Modality.WINDOW_MODAL);
                nnstage.setResizable(false);
                //   nnstage.initModality(Modality.APPLICATION_MODAL);
                nnstage.setScene(scene);
                nnstage.show();

                // coverage_tab.disableProperty().setValue(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(ProjectModel.gen.equals("3G/UMTS NETWORK")){
            try {

                Parent root = null;
                //TODO check if project instance is null
                root = (Parent)new FXMLLoader().load(getClass().getResource("../views/Budget_UMTS.fxml"));
                // lteicons.initialise4GIcons();
                Scene scene = new Scene(root);
                Stage nnstage = new Stage();
                nnstage.getIcons().add(new Image("./sample/icons/antenna_marker1.png"));
                nnstage.initModality(Modality.WINDOW_MODAL);
                nnstage.setResizable(false);
                //   nnstage.initModality(Modality.APPLICATION_MODAL);
                nnstage.setScene(scene);
                nnstage.show();

                // coverage_tab.disableProperty().setValue(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(ProjectModel.gen.equals("4G/LTE NETWORK")){
            try {

                Parent root = null;
                //TODO check if project instance is null
                root = (Parent)new FXMLLoader().load(getClass().getResource("../views/Budget.fxml"));
                // lteicons.initialise4GIcons();
                Scene scene = new Scene(root);
                Stage nnstage = new Stage();
                nnstage.getIcons().add(new Image("./sample/icons/antenna_marker1.png"));
                nnstage.initModality(Modality.WINDOW_MODAL);
                nnstage.setResizable(false);
                //   nnstage.initModality(Modality.APPLICATION_MODAL);
                nnstage.setScene(scene);
                nnstage.show();

                // coverage_tab.disableProperty().setValue(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void loadMap(ActionEvent event){
               cmd_loadmap.setVisible(false);
            WebEngine webEngine = GoogleMap.getEngine();
            final URL urlGoogleMaps = getClass().getResource("./GoogleMaps.html");
            webEngine.load(urlGoogleMaps.toExternalForm());
            webEngine.setJavaScriptEnabled(true);
    }


}

