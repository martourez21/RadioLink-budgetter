package sample.notification;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.util.ResourceBundle;

public class Notify implements Initializable {

    Notifications notify = Notifications.create();
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void notifyInvalidator(){
        notify.title("InputField Validator Notification").text("Input is not valid").hideAfter(Duration.seconds(1)).position(Pos.CENTER).showError();

    }

    public void notification(){
        notify.title("Project Creation Notification").text("Project Created Successfully!!").hideAfter(Duration.seconds(1)).position(Pos.CENTER).showInformation(); // sets node to display.hideAfter(Duration.seconds(10))
    }
    public void notifyErr(){
        notify.title("Database Notification").text("Data not Saved Successfully!!").hideAfter(Duration.seconds(1)).position(Pos.CENTER).showError();
    }
    public void notifyUpdate(){
        notify.title("Data Update Notification").text("Data Updated Successfully!!").hideAfter(Duration.seconds(1)).position(Pos.CENTER).showInformation();
    }
    public void notifyUpdateErr(){
        notify.title("Database Notification").text("Data Update was Unsuccessful!!").hideAfter(Duration.seconds(1)).position(Pos.CENTER).showError();
    }

}
