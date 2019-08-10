package sample.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import java.net.URL;
import java.util.ResourceBundle;

public class ProgressBarController implements Initializable {
   private static final Integer TIME_LAPSE =15;
    @FXML
    private ProgressBar progress_bar_indicator;
    @FXML
    private ProgressIndicator progress_indicator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    private IntegerProperty time = new SimpleIntegerProperty(TIME_LAPSE);

    public void getProgress_bar_indicator() {
        progress_bar_indicator.progressProperty().bind(time.divide(TIME_LAPSE*1.0));
    }
}

