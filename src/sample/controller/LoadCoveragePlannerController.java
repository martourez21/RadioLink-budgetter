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
import sample.model.ProjectModel;
import sample.model.PropagationModelClass;
import sample.notification.Notify;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static java.lang.Float.parseFloat;

public class LoadCoveragePlannerController implements Initializable {
   Model model = new Model();
   PropagationModelClass propagationfunction = new PropagationModelClass();
    sample.notification.Notify notifymessage = new Notify();
 public double EIRP =0.0;

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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            IN1.getItems().addAll("PHY UL CHANNEL", "DL SHARED CHANNEL");
            IN2.getItems().addAll("FDD", "TDD");
            IN3.getItems().addAll("INDOOR", "OUTDOOR");
            IN4.getItems().addAll("1.4MHz", "3MHz", "5MHz", "10MHz", "15MHz", "20MHz");
            IN5.getItems().addAll("128", "256", "512", "1024");
            IN6.getItems().addAll("1800", "2100", "2600");
            IN7.getItems().addAll("DENSE URBAN", "URBAN", "SUBURBAN", "RURAL");
            IN8.getItems().addAll("60", "70", "80", "90", "100");
            IN9.getItems().addAll("OKUMURA-HATA", "COST231-HATA", "WALFISH-IKEGAMI");
            IN13.getItems().addAll("OMNIDIRECTIONAL", "3-SECTORIAL");
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

    public void set_systemParams(ActionEvent event){
        try {
            model.updateProject("lte_table", new String[]{"dcht", "dm", "ue", "sbw", "cet", "fb", "tm"}, new String[]{IN1.getValue(), IN2.getValue(), IN3.getValue(), IN4.getValue(), IN5.getValue(), IN6.getValue(), IN7.getValue()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            cmd_set_param.setDisable(true);
            cmd_update.setDisable(false);
            String y = String.valueOf(IN6.getValue());
            IN12.setText(y);
            notifymessage.notification();
        }catch(SQLException e){
            notifymessage.notifyErr();
            e.getCause();
        }
    }
    public void update(ActionEvent event){
        try {
            String y = String.valueOf(IN6.getValue());
            IN12.setText(y);

            model.updateProject("lte_table", new String[]{"dcht", "dm", "ue", "sbw", "cet", "fb", "tm"}, new String[]{IN1.getValue(), IN2.getValue(), IN3.getValue(), IN4.getValue(), IN5.getValue(), IN6.getValue(), IN7.getValue()});
            notifymessage.notifyUpdate();
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
        }catch(SQLException e){
            notifymessage.notifyUpdateErr();
            e.getCause();
        }
    }
    public void save1(ActionEvent event){
        try {
            model.updateProject("lte_table", new String[]{"mttp", "arb", "rbdp", "tag", "tcl", "tbl", "scdp","scp"}, new String[]{A.getText(),B.getText(),C.getText(),G.getText(),H.getText(),I.getText(),D.getText(),E.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            notifymessage.notification();
            cmd_save1.setDisable(true);
            cmd_update1.setDisable(false);
        }catch(SQLException e){
            e.getCause();
            notifymessage.notification();
        }
    }
    public void update1(ActionEvent event){
        try {

            model.updateProject("lte_table", new String[]{"mttp", "arb", "rbdp", "tag", "tcl", "tbl", "scdp","scp"}, new String[]{A.getText(),B.getText(),C.getText(),G.getText(),H.getText(),I.getText(),D.getText(),E.getText()});
          notifymessage.notifyUpdate();
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
        }catch(SQLException e){
            notifymessage.notifyUpdateErr();
            e.getCause();
        }
    }
    public void calculate_dl(ActionEvent event){
        double scdp;
        double sc,eirp, g1,g2,g3,g4,g5;
        float c = Float.parseFloat(C.getText());
        //double rblock = Integer.parseInt(A.getText());
        scdp = 12 * c;
        // double d = Double.
        //
        // parseDouble(D.getText());
        sc = (parseFloat(A.getText())) - 10*Math.log10(scdp);


        // g1 = String.format("%.2f", sc);

        float g = parseFloat(G.getText());
        float h = parseFloat(H.getText());
        float i = parseFloat(I.getText());

        EIRP = sc + g - h - i;    //Calculating the Effective Isotropic Radiated Power

        D.setText(String.valueOf(scdp));
        E.setText(String.format("%.4f", sc));
        J.setText(String.format("%.4f", EIRP));

        /* retrieving the calculated output result then filling the gauges gauge1 and gauge2 */
        double v1  = Double.parseDouble(E.getText());
        gauge1.setVisible(true);
        gauge1.setValue(v1);
        gauge2.setVisible(true);
        double v2 = Double.parseDouble(J.getText());
        gauge2.setValue(v2);
        gauge5.setVisible(true);
        gauge5.setValue(v1);
        gauge6.setVisible(true);
        gauge6.setValue(v2);
     //propagationfunction.setOkumuraHata(Integer.valueOf());
    }
    public void calculate_ul(ActionEvent event){
    double m = 174.0;
    double rs ;
    float k= parseFloat(K.getText());
    float l = parseFloat(L.getText());
    rs =  k + l - m + 10*Math.log10(15000);
    gauge3.setVisible(true);
    gauge3.setValue(rs);
    double msrs = rs - parseFloat(N.getText()) + parseFloat(O.getText()) + parseFloat(P.getText()) + parseFloat(Q.getText());
    gauge4.setVisible(true);
    gauge4.setValue(msrs);
    M.setText(String.format("%.4f", rs));
    R.setText(String.format("%.4f", msrs));

    double v3  = Double.parseDouble(M.getText());

    gauge3.setVisible(true);
    gauge3.setValue(v3);
    gauge4.setVisible(true);
    double v4 = Double.parseDouble(R.getText());
    gauge4.setValue(v4);
    gauge7.setVisible(true);
    gauge7.setValue(v3);
    gauge8.setVisible(true);
    gauge8.setValue(v4);
    gauge4.setValue(msrs);

}
    public void save2(ActionEvent event){
        try {
            model.updateProject("lte_table", new String[]{"snir", "rnf", "rag","rcl","rbl","tl","im","rs"}, new String[]{K.getText(),L.getText(),N.getText(),O.getText(),P.getText(),IN8.getValue(),Q.getText(),M.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
           notifymessage.notification();
            cmd_save2.setDisable(true);
            cmd_update2.setDisable(false);
        }catch(SQLException e){
            notifymessage.notifyErr();
            e.getCause();
        }
    }
    public void update2(ActionEvent event){
        try {

            model.updateProject("lte_table", new String[]{"snir", "rnf", "rag","rcl","rbl","tl","im","rs"}, new String[]{K.getText(),L.getText(),N.getText(),O.getText(),P.getText(),IN8.getValue(),Q.getText(),M.getText()});
           notifymessage.notifyUpdate();
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
        }catch(SQLException e){
            notifymessage.notifyUpdateErr();
            e.getCause();
        }
    }
    public void calculate_finalBudget(ActionEvent event) throws Throwable{
        System.out.println("++++++++++++++++++++++REFERNCE :" +propagationfunction.getCellRadius());
        float tsa;//declaring total surface area
        double NoC; //Number of Cells
        int NeNB; //Number of eNodeBs
        double mapl;
        //System.out.println("------------EIRP Value-----------" +model.getEirp());
        mapl = (Double.valueOf(J.getText()) - Double.valueOf(R.getText())-Double.valueOf(S.getText())-Double.valueOf(T.getText()));
        System.out.println("mpl" + mapl);
        System.out.println("        ////////////////             Before PropagationModel Function set");
       // propagationfunction.setOkumuraHata(Integer.valueOf(model.getFb()),model.getTm(),Float.valueOf(model.getUeh()),Float.valueOf(model.getEnbh()),mapl,model.getPm());
        propagationfunction.setOkumuraHata(Integer.parseInt(IN6.getValue()),IN7.getValue(),Float.parseFloat(IN10.getText()),Float.parseFloat(IN11.getText()),mapl,IN9.getValue());

        System.out.println("        ////////////////             after PropagationModelFunction set");
        if(IN13.getValue().equals("OMNIDIRECTIONAL") ){

            double apc;// Area per cell
            double p =propagationfunction.getCellRadius();
            apc = 1.5 * Math.sqrt(3.0) * Math.pow(p,2);
            System.out.println("Area per cell For omni site:" + apc);
            System.out.println(apc);

            tsa = Float.parseFloat(IN14.getText());
            NoC = tsa / apc ;
            NeNB = (int)Math.ceil(NoC);
            System.out.println("Number of EnodeBs using omni-sites:" + NeNB);
            O1.setText(String.format("%.4f", mapl));
            O2.setText(String.format("%.4f", p));
            O3.setText(String.valueOf(NeNB));
            double v9  = Double.parseDouble(O1.getText());
            gauge9.setVisible(true);
            gauge9.setValue(v9);
            gauge11.setVisible(true);
            double v11 = Double.parseDouble(O3.getText());
            gauge11.setValue(v11);

        }else{
            double p1 = propagationfunction.getCellRadius();
            double apc1 = 1.125 * Math.sqrt(3) * Math.pow(p1,2);
            System.out.println("Area per cell For 3-sectorial site:" + apc1);
            float tsa1 = Float.parseFloat(IN14.getText());
            NoC = tsa1 / apc1;
            NeNB = (int)Math.ceil(NoC);
            System.out.println("Number of EnodeBs using 3-sectorial-sites:" + NeNB);
            O1.setText(String.format("%.4f", mapl));
            O2.setText(String.format("%.4f", p1));
            O3.setText(String.valueOf(NeNB));

            double v9  = Double.parseDouble(O1.getText());
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
    public void save3(ActionEvent event){
        try {
            model.updateProject("lte_table", new String[]{"eirp","msrs","ipl","sfm","pm","ueh","enbh","cf","st","tsa","mapl","cr","nenb"}, new String[]{J.getText(),R.getText(),S.getText(),T.getText(),IN9.getValue(),IN10.getText(),IN11.getText(),IN12.getText(),IN13.getValue(),IN14.getText(),O1.getText(),O2.getText(),O3.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
            cmd_save3.setDisable(true);
            cmd_update3.setDisable(false);
        }catch(SQLException e){
            e.getCause();
        }
    }
    public void update3(ActionEvent event){
        try {
            model.updateProject("lte_table", new String[]{"eirp","msrs","ipl","sfm","pm","ueh","enbh","cf","st","tsa","mapl","cr","nenb"}, new String[]{J.getText(),R.getText(),S.getText(),T.getText(),IN9.getValue(),IN10.getText(),IN11.getText(),IN12.getText(),IN13.getValue(),IN14.getText(),O1.getText(),O2.getText(),O3.getText()});
            System.out.println("//////////////------------DATA INSERTED SUCCESSFULLY------------///////////////////");
        }catch(SQLException e){
            e.getCause();
        }
    }

}

