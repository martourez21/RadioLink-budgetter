package sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
    public  static Connection getConnection(){
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            String url  = "jdbc:sqlite:"+System.getProperty("user.dir")+"/src/sample/entity/db.db";

            con = DriverManager.getConnection(url);
        }catch (Exception sql){
            System.out.println(sql.getMessage());
        }
        if(con != null){

            System.out.println(" ///////////       connected to db");
        }
        return con;
    }

  /* public static void main(String[] args) throws SQLException {
        Connection myConnectionDb = ConnectionDb.getConnection();

        if (myConnectionDb.equals(null)){
            System.out.println("not yet es");

        }else {
            System.out.println("ConnectionDb establish");
        }

        if(myConnectionDb.isClosed()){
            System.out.println(" ///////////       not yet es");
        }else{
            System.out.println("connection open");
        }


    } */

}
