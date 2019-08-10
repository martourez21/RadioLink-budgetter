package sample.model;

public class PropagationModelClass extends Model {

   private double cell_radius = 0.0;
    public double getCellRadius() {
        System.out.print("$$$$$$$$$$$$$  cell Radius:::::::  "+  cell_radius);
        return cell_radius;
    }

    public void setOkumuraHata(int FR, String TM, float UEH, float BTSH, double MAPL, String PM ){
        try{
            if(TM.equals("RURAL") && PM.equals("OKUMURA-HATA")){

                double s1 = 44.9 - 6.55*Math.log10(BTSH);
                double pl1 = 33.6 + 7.8*Math.log10(FR) - 13.8*Math.log10(BTSH) -4.8 * Math.pow(Math.log10(FR), 2) -3.2 * Math.pow(Math.log10(11.8*UEH), 2);
                double cal = (MAPL - pl1) / s1;
                System.out.println(Math.pow(10 , cal));
                cell_radius = Math.pow(10 , cal);
                //cr.add(Math.pow(10 , cal));
                //O2.setText(String.valueOf(cr));
            }else if(TM.equals("SUBURBAN") && PM.equals("OKUMURA-HATA")){
                double s2 = 44.9 - 6.55*Math.log10(BTSH);
                double pl2 = 59.2 + 26.2*Math.log10(FR) - 13.8*Math.log10(BTSH) - 3.2 * Math.pow(Math.log10(11.8*UEH), 2) -2 * Math.pow(Math.log10(FR/28), 2);
                double cal1 = (MAPL - pl2) / s2;
                cell_radius = Math.pow(10 , cal1);
                //cr.add(Math.pow(10 , cal1));
                //O2.setText(String.valueOf(cr));
            }else if(TM.equals("URBAN") && PM.equals("OKUMURA-HATA")){
                double s3 = 44.9 - 6.55*Math.log10(BTSH);
                double pl3 = 68.8 + (26.2 * Math.log10(FR)) - (13.8*Math.log10(BTSH)) - (UEH * (1.1*Math.log10(FR) -0.7)) + (1.6*Math.log10(FR));
               // double pl3 = 68.8 + 26.2*Math.log10(FR) - 13.8*Math.log10(BTSH) - UEH * (1.1*Math.log10(FR) - 0.7) -1.6 * Math.log(FR);
                double cal2 = (MAPL - pl3)/s3;
                System.out.println("#################----CAL2::::::" +cal2);
                cell_radius = Math.pow(10 , cal2);
               // cr.add(Math.pow(10 , cal2));
                //O2.setText(String.valueOf(cr));
            }else if(TM.equals("DENSE URBAN") && PM.equals("OKUMURA-HATA")){
                double s4 = 44.9 - 6.55*Math.log10(BTSH);
                double pl4 = 74.5 + 26.2*Math.log10(FR) - 13.8*Math.log10(BTSH) - 3.2 * Math.pow(Math.log10(11.8 * UEH), 2);
                double cal3 = (MAPL - pl4)/s4;
                cell_radius = Math.pow(10 , cal3);
               // cr.add(Math.pow(10 , cal3));
                //O2.setText(String.valueOf(cr));
            }else if(TM.equals("RURAL") && PM.equals("COST231-HATA")){
                double s5 = 44.9 - 6.55*Math.log10(BTSH);
                double pl5 = 10.3 + 15.6*Math.log10(FR) - 13.8 *Math.log10(BTSH) - 3.2 * (Math.pow(Math.log10(11.8*UEH), 2)) - 4.8 * Math.pow(Math.log10(FR), 2);
                double cal4 = (MAPL - pl5) / s5;
                cell_radius = Math.pow(10 , cal4);
               // cr.add(Math.pow(10, cal4));
            }else if(TM.equals("SUBURBAN") && PM.equals("COST231-HATA")){
                double s6 = 44.9 - 6.55*Math.log10(BTSH);
                double pl6 = 45.9 + 33.9*Math.log10(FR) - 13.8 *Math.log10(BTSH) - 3.2 * (Math.pow(Math.log10(11.8*UEH), 2)) - 2 * Math.pow(Math.log10(FR/28), 2);
                double cal5 = (MAPL - pl6) / s6;
                cell_radius = Math.pow(10 , cal5);
               // cr.add(Math.pow(10, cal5));
            }else if(TM.equals("URBAN") && PM.equals("COST231-HATA")){
                double s7 = 44.9 - 6.55*Math.log10(BTSH);
                double pl7 = 45.5 + 33.9*Math.log10(FR) - 13.8 *Math.log10(BTSH) - UEH*(1.1*Math.log10(FR) - 0.7) + 1.6 *Math.log10(FR);
                double cal6 = (MAPL - pl7) / s7;
                System.out.println("#################----CAL6::::::" +cal6);
                cell_radius = Math.pow(10 , cal6);
                //cr.add(Math.pow(10, cal6));
            }else if(TM.equals("DENSE URBAN") && PM.equals("COST231-HATA")){
                double s8 = 44.9 - 6.55*Math.log10(BTSH);
                double pl8 = 54.3 + 33.9*Math.log10(FR) - 13.8 *Math.log10(BTSH) - 3.2 * (Math.pow(Math.log10(11.8*UEH), 2));
                double cal7 = (MAPL - pl8) / s8;
                cell_radius = Math.pow(10 , cal7);
               // cr.add(Math.pow(10, cal7));
            }
        }catch (Exception e) {
            // System.out.print("Cannot insert data into table: parameter");
            System.err.println(e.getClass().getName() + ": " + e.getMessage() +":" + e.getStackTrace());
        }

    }

    }

