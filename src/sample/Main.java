package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;
import sample.controller.Controller;
import sample.controller.CreateProjectController;

public class Main extends Application {

    @FXML
    private TextField txt_project_name;
    CreateProjectController name =new CreateProjectController();
    @Override
    public void start(Stage primaryStage) throws Exception{
       // JMetro jmetro = new JMetro(JMetro.Style.LIGHT);
        Parent root = FXMLLoader.load(getClass().getResource("../sample/views/home.fxml"));
       // jmetro.applyTheme(root);
        primaryStage.setTitle("RADIO PLANNEX Pro v1.0");
        primaryStage.getIcons().add(new Image("./sample/icons/antenna_marker1.png"));
        primaryStage.setScene(new Scene(root, Control.USE_COMPUTED_SIZE, Control.USE_COMPUTED_SIZE));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
        double s7 = 44.9 - 6.55*Math.log10(30);
        double pl7 = 45.5 + 33.9*Math.log10(900) - 13.8 *Math.log10(30) - 1.5*(1.1*Math.log10(900) - 0.7) + 1.6 *Math.log10(900);
        double cal6 = (123.37 - pl7) / s7;
        System.out.println("#################----CAL6::::::" +cal6);
        double cell_radius = Math.pow(10 , cal6);
        System.out.println("---------------CELL RADIUS :::" + cell_radius);
    }

}
