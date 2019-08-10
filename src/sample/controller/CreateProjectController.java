package sample.controller;

import com.jfoenix.controls.JFXButton;
import eu.hansolo.medusa.Gauge;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.NotificationPane;
import sample.Main;
import sample.model.Model;
import sample.model.ProjectModel;
import sample.notification.Notify;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateProjectController implements Initializable {
    Notify notifymessage = new Notify();
    FXMLLoader fxmlLoader = new FXMLLoader();
    InitializationClass lteicons = new InitializationClass();
    @FXML
    private ComboBox<String> combo_select_network;

    @FXML
    private TextField txt_project_name;
    @FXML
    private AnchorPane project_create;
    @FXML
    private Button cmd_create;
    @FXML
    private Button cmd_coverage_module;

    @FXML
    private Button cmd_cancel;

    @FXML
    private Button cmd_create_project;
    @FXML
    private Pane pane1;
    @FXML
    private Tab coverage_tab;

    private ProjectModel project;
    @FXML
    ProjectModel pm = new ProjectModel();
    Controller controller = new Controller();
    @Override
    public void initialize(URL location, final ResourceBundle resources) {
       combo_select_network.getItems().addAll("2G/GSM NETWORK", "3G/UMTS NETWORK", "4G/LTE NETWORK");
       cmd_create.setGraphic(new ImageView("./sample/icons/ok.png"));
       cmd_cancel.setGraphic(new ImageView("./sample/icons/close1.png"));


       cmd_create.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               String gen = combo_select_network.getValue();
               String name = txt_project_name.getText();
               Stage stage = (Stage)cmd_create.getScene().getWindow();
               stage.close();
               try {
                   project = new ProjectModel(name,gen);
                  project = new Model().create(project);
                   new ProjectModel().setProject(project);
                    notifymessage.notification();


               } catch (SQLException e) {
                   notifymessage.notifyErr();
                   e.printStackTrace();
               }
           }
       });

        cmd_cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage)cmd_create.getScene().getWindow();
                stage.close();
            }
        });
    }


    }


