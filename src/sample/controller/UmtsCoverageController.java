package sample.controller;

import eu.hansolo.medusa.Gauge;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import org.controlsfx.control.NotificationPane;
import sample.model.Model;
import sample.model.PropagationModelClass;
import sample.notification.Notify;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.lang.Float.parseFloat;

public class UmtsCoverageController implements Initializable {
    Model model = new Model();
    PropagationModelClass propagationfunction1 = new PropagationModelClass();
    sample.notification.Notify notifymessage = new Notify();
    public double EIRP = 0.0;
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
    private TextField F;
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
    private Gauge gauge31;
    @FXML
    private Gauge gauge311;
    @FXML
    private Gauge gauge32;
    @FXML
    private Gauge gauge312;
    @FXML
    private Gauge gauge3111;

    @FXML
    private Gauge gauge4;

    @FXML
    private TextField S;

    @FXML
    private TextField T;

    @FXML
    private ComboBox<String> IN12;
    @FXML
    private TextField IN10;
    @FXML
    private TextField IN11;
    @FXML
    private TextField IN9;
    @FXML
    private TextField IN13;
    @FXML
    private TextField IN14;
    @FXML
    private TextField O1;
    @FXML
    private TextField O2;
    @FXML
    private TextField O3;
    @FXML
    private TextField U;
    @FXML
    private TextField V;
    @FXML
    private TextField W;
    @FXML
    private TextField X;


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

    LoadCoveragePlannerController tt = new LoadCoveragePlannerController();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IN1.getItems().addAll("UPLINK", "DOWNLINK");
        IN2.getItems().addAll("FDD", "TDD");
        IN3.getItems().addAll("INDOOR", "OUTDOOR");
        IN4.getItems().addAll("5MHz", "10MHz", "15MHz", "20MHz");
        IN5.getItems().addAll("3.84", "1.92", "0.96", "0.48", "0.24", "0.12");
        IN6.getItems().addAll("700", "800", "900", "1800", "2100", "2600");
        IN7.getItems().addAll("DENSE URBAN", "URBAN", "SUBURBAN", "RURAL");
        //IN8.getItems().addAll("60", "70", "80", "90", "100");
        IN8.getItems().addAll("OKUMURA-HATA", "COST231-HATA", "WALFISH-IKEGAMI");
        IN12.getItems().addAll("OMNIDIRECTIONAL", "3-SECTORIAL");
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

    public void set_systemParams(ActionEvent event) {
        try {
            model.updateProject("umts_table", new String[]{"dir", "dm", "ue", "sbw", "cet", "fb", "tm"}, new String[]{IN1.getValue(), IN2.getValue(), IN3.getValue(), IN4.getValue(), IN5.getValue(), IN6.getValue(), IN7.getValue()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            cmd_set_param.setDisable(true);
            cmd_update.setDisable(false);
            String y = String.valueOf(IN6.getValue());
            IN11.setText(y);
            // notifymessage.notification();
        } catch (SQLException e) {
            notifymessage.notifyErr();
            e.getCause();
        }
    }

    public void update(ActionEvent event) {
        try {
            model.updateProject("umts_table", new String[]{"dir", "dm", "ue", "sbw", "cet", "fb", "tm"}, new String[]{IN1.getValue(), IN2.getValue(), IN3.getValue(), IN4.getValue(), IN5.getValue(), IN6.getValue(), IN7.getValue()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            cmd_set_param.setDisable(true);
            cmd_update.setDisable(false);
            String y = String.valueOf(IN6.getValue());
            IN11.setText(y);
            // notifymessage.notification();
        } catch (SQLException e) {
            notifymessage.notifyErr();
            e.getCause();
        }
    }

    public void save1(ActionEvent event) {
        try {
            model.updateProject("umts_table", new String[]{"mtp", "tag", "tcl", "tbl", "eirp"}, new String[]{A.getText(), B.getText(), C.getText(), D.getText(), E.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            notifymessage.notification();
            cmd_save1.setDisable(true);
            cmd_update1.setDisable(false);
        } catch (SQLException e) {
            e.getCause();
            notifymessage.notification();
        }
    }

    public void update1(ActionEvent event) {
        try {
            model.updateProject("umts_table", new String[]{"mtp", "tag", "tcl", "tbl", "eirp"}, new String[]{A.getText(), B.getText(), C.getText(), D.getText(), E.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            notifymessage.notification();
            cmd_save1.setDisable(true);
            cmd_update1.setDisable(false);
        } catch (SQLException e) {
            e.getCause();
            notifymessage.notification();
        }
    }

    public void calculate_dl(ActionEvent event) {

        double eirp, g1, g2, g3, g4, g5;

        // g1 = String.format("%.2f", sc);

        float a = parseFloat(A.getText());
        float b = parseFloat(B.getText());
        float c = parseFloat(C.getText());
        float d = parseFloat(D.getText());

        EIRP = a + b - c - d;  //Calculating the Effective Isotropic Radiated Power

        E.setText(String.format("%.4f", EIRP));

        /* retrieving the calculated output result then filling the gauges gauge1 and gauge2 */
        gauge1.setValue(EIRP);

    }

    public void calculate_ul(ActionEvent event) {

        double h = Double.parseDouble(F.getText()) + Double.parseDouble(G.getText());
        double i = h + (10 * Math.log10(3840000));
        double k = i + Double.parseDouble(J.getText());
        double in5 = Double.parseDouble(IN5.getValue());
        double l = 10 * Math.log10(3840 / in5);
        double n = Double.parseDouble(M.getText()) - l + k;
        double t = Double.parseDouble(E.getText()) - n + Double.parseDouble(O.getText()) - Double.parseDouble(P.getText()) - Double.parseDouble(Q.getText()) - Double.parseDouble(R.getText()) + Double.parseDouble(S.getText());

        H.setText(String.format("%.4f", h));
        I.setText(String.format("%.4f", i));
        K.setText(String.format("%.4f", k));
        L.setText(String.format("%.4f", l));
        N.setText(String.format("%.4f", n));
        T.setText(String.format("%.4f", t));

        gauge3.setValue(h);
        gauge31.setValue(l);
        gauge311.setValue(n);
        gauge32.setValue(i);
        gauge312.setValue(k);
        gauge3111.setValue(t);

    }

    public void save2(ActionEvent event) {
        try {
            model.updateProject("umts_table", new String[]{"tnd", "rnf", "rnd", "rnp", "im", "teni", "pg", "EbNo", "rs", "rag", "rcl", "rbl", "ffm", "dg", "pl"}, new String[]{F.getText(), G.getText(), H.getText(), I.getText(), J.getText(), K.getText(), L.getText(), M.getText(), N.getText(), O.getText(), P.getText(), Q.getText(), R.getText(), S.getText(), T.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            //notifymessage.notification();
            cmd_save2.setDisable(true);
            cmd_update2.setDisable(false);
        } catch (SQLException e) {
            notifymessage.notifyErr();
            e.getCause();
        }
    }

    public void update2(ActionEvent event) {
        try {
            model.updateProject("umts_table", new String[]{"tnd", "rnf", "rnd", "rnp", "im", "teni", "pg", "EbNo", "rs", "rag", "rcl", "rbl", "ffm", "dg", "pl"}, new String[]{F.getText(), G.getText(), H.getText(), I.getText(), J.getText(), K.getText(), L.getText(), M.getText(), N.getText(), O.getText(), P.getText(), Q.getText(), R.getText(), S.getText(), T.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            //notifymessage.notification();
            cmd_save2.setDisable(true);
            cmd_update2.setDisable(false);
        } catch (SQLException e) {
            notifymessage.notifyErr();
            e.getCause();
        }
    }

    public void calculate_finalBudget(ActionEvent event) throws Throwable {
        float tsa;//declaring total surface area
        double NoC; //Number of Cells
        int NeNB; //Number of eNodeBs
        double mapl = (Double.valueOf(T.getText()) - Double.valueOf(U.getText()) - Double.valueOf(V.getText()) - Double.valueOf(W.getText()) + Double.parseDouble(X.getText()));
        System.out.println("mapl" + mapl);
        System.out.println("        ////////////////             Before PropagationModel Function set");
        // propagationfunction.setOkumuraHata(Integer.valueOf(model.getFb()),model.getTm(),Float.valueOf(model.getUeh()),Float.valueOf(model.getEnbh()),mapl,model.getPm());
        propagationfunction1.setOkumuraHata(Integer.parseInt(String.valueOf(IN11.getText())), IN7.getValue(), Float.parseFloat(String.valueOf(IN9.getText())), Float.parseFloat(String.valueOf(IN10.getText())), mapl, IN8.getValue());
        System.out.println("        ////////////////             after PropagationModelFunction set");
        if (IN12.getValue().equals("OMNIDIRECTIONAL")) {

            double apc;// Area per cell
            double p = propagationfunction1.getCellRadius();
            apc = 1.5 * Math.sqrt(3.0) * Math.pow(p, 2);
            System.out.println("Area per cell For omni site:" + apc);
            System.out.println(apc);

            tsa = Float.parseFloat(IN13.getText());
            NoC = tsa / apc;
            NeNB = (int) Math.ceil(NoC);
            System.out.println("Number of EnodeBs using omni-sites:" + NeNB);
            O1.setText(String.format("%.4f", mapl));
            O2.setText(String.format("%.4f", p));
            O3.setText(String.valueOf(NeNB));
            double v9 = Double.parseDouble(O1.getText());
            gauge9.setVisible(true);
            gauge9.setValue(v9);
            gauge11.setVisible(true);
            double v11 = Double.parseDouble(O3.getText());
            gauge11.setValue(v11);

        } else {
            double p1 = propagationfunction1.getCellRadius();
            double apc1 = 1.125 * Math.sqrt(3) * Math.pow(p1, 2);
            System.out.println("Area per cell For 3-sectorial site:" + apc1);
            float tsa1 = Float.parseFloat(IN13.getText());
            NoC = tsa1 / apc1;
            NeNB = (int) Math.ceil(NoC);
            System.out.println("Number of EnodeBs using 3-sectorial-sites:" + NeNB);
            O1.setText(String.format("%.4f", mapl));
            O2.setText(String.format("%.4f", p1));
            O3.setText(String.valueOf(NeNB));

            double v9 = Double.parseDouble(O1.getText());
            gauge9.setVisible(true);
            // gauge9.setThresholdColor(RED);
            gauge9.setValue(v9);
/*               gauge10.setVisible(true);
               double v10 = Double.parseDouble(O2.getText());
               gauge10.setValue(v10); */
            gauge11.setVisible(true);
            double v11 = Double.parseDouble(O3.getText());
            gauge11.setValue(v11);

        }


    }

    public void save3(ActionEvent event) {
        try {
            model.updateProject("umts_table", new String[]{"bpl", "cpl", "lnfm", "shg", "pm", "ueh", "bth", "cf", "st", "tsa", "mapl", "cr", "nnb"}, new String[]{U.getText(), V.getText(), W.getText(), X.getText(), IN8.getValue(), IN9.getText(), IN10.getText(), IN11.getText(), IN12.getValue(), IN13.getText(), O1.getText(), O2.getText(), O3.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            cmd_save3.setDisable(true);
            cmd_update3.setDisable(false);
        } catch (SQLException e) {
            e.getCause();
        }
    }
    public void update3(ActionEvent event) {
        try {
            model.updateProject("umts_table", new String[]{"bpl", "cpl", "lnfm", "shg", "pm", "ueh", "bth", "cf", "st", "tsa", "mapl", "cr", "nnb"}, new String[]{U.getText(), V.getText(), W.getText(), X.getText(), IN8.getValue(), IN9.getText(), IN10.getText(), IN11.getText(), IN12.getValue(), IN13.getText(), O1.getText(), O2.getText(), O3.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            cmd_save3.setDisable(true);
            cmd_update3.setDisable(false);
        } catch (SQLException e) {
            e.getCause();
        }
    }
}
