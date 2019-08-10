package sample.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Model {
    ResultSet result;
    Connection con;

   private String project_id, gen,eirp,mapl,msrs;

    public Model( String project_id) {
        this.project_id = project_id;
        con = new ConnectionDb().getConnection();
        ResultSet rs = null;
        try {
            rs = con.prepareStatement("select gen from project where id = '"+project_id+"'").executeQuery();
            rs.next();
            //rs.first();
            //get generation
            gen = rs.getString("gen");

            //checking generation
            if(gen.startsWith("4")){
                result = con.prepareStatement("select * from lte_table join project on (project.id = lte_table.pro_id) where lte_table.pro_id = '"+project_id+"'").executeQuery();
            }
            //rs.first();
             rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getName() throws SQLException {
        return result.getString("name");
    }

    public String getDcht() throws SQLException {
        return result.getString("dcht");
    }

    public String getDm() throws SQLException{
        return result.getString("dm");
    }

    public String getUe() throws SQLException  {
        return result.getString("ue");
    }

    public String getSbw() throws SQLException {
        return result.getString("sbw");
    }

    public String getCet() throws SQLException {
        return result.getString("cet");
    }

    public String getFb() throws SQLException {
        return result.getString("fb");
    }

    public String getTm() throws SQLException {
        return result.getString("tm");
    }

    public String getMttp() throws SQLException {
        return result.getString("mttp");
    }

    public String getArb() throws SQLException {
        return result.getString("arb");
    }

    public String getRbdp() throws SQLException {
        return result.getString("rbdp");
    }

    public String getTag() throws SQLException {
        return result.getString("tag");
    }

    public String getTcl() throws SQLException {
        return result.getString("tcl");
    }

    public String getTbl() throws SQLException {
        return result.getString("tbl");
    }

    public String getSnir() throws SQLException {
        return result.getString("snir");
    }

    public String getRnf() throws SQLException {
        return result.getString("rnf");
    }

    public String getRag() throws SQLException {
        return result.getString("rag");
    }

    public String getRcl() throws SQLException {
        return result.getString("rcl");
    }

    public String getRbl() throws SQLException {
        return result.getString("rbl");
    }

    public String getIm() throws SQLException {
        return result.getString("im");
    }

    public String getTl() throws SQLException {
        return result.getString("tl");
    }

    public String getIpl() throws SQLException {
        return result.getString("ipl");
    }

    public String getSfm() throws SQLException {
        return result.getString("sfm");
    }

    public String getPm() throws SQLException {
        return result.getString("pm");
    }

    public String getUeh() throws SQLException {
        return result.getString("ueh");
    }

    public String getEnbh() throws SQLException {
        return result.getString("enbh");
    }

    public String getCf() throws SQLException {
        return result.getString("cf");
    }

    public String getSt() throws SQLException {
        return result.getString("st");
    }

    public boolean updateProject(String table, String[] colums, String[] data) throws SQLException {
        if(colums.length == data.length){
            String sql = "update "+table+" set "+
                   getKeyValue(colums, data)
                    + " where (pro_id = '"+new ProjectModel().getId()+"');";
            System.out.println(sql);
        return    (con.prepareStatement(sql).executeUpdate() == 1)? true : false;
        }else{
            System.out.println("Data dont match!!!1!!!");
            return false;
        }

    }

    private String getKeyValue(String[] colums, String[] data) {
        String keyValue = "";
        for(int i = 0; i< colums.length; i++){
            String col_val = colums[i]+" = '"+data[i]+"'" + ( i < (colums.length -1) ? ",":"");
            keyValue = keyValue+col_val;
        }
        return  keyValue;
    }

    public Model() {
        con = new ConnectionDb().getConnection();
    }

    //create new project and save id, requires project name and generation
    public ProjectModel create(ProjectModel projectModel) throws SQLException {
        con.setAutoCommit(false);
        PreparedStatement ps = con.prepareStatement("insert into project (name,gen) Values ( '"+projectModel.getName()+"' ,'"+ projectModel.getGen()+"' )");
        ps.executeUpdate();
        ps.close();
        ResultSet set = con.prepareStatement("select max(id) as id from project").executeQuery();
        set.next();
        int id = set.getInt("id");
        set.close();
        if(projectModel.getGen().startsWith("2")){
        PreparedStatement ps1 = con.prepareStatement("insert into gsm_table (pro_id) Values ( '"+ id+"' )");
        ps1.executeUpdate();
        ps.close();
        }else if(projectModel.getGen().startsWith("3")){
                PreparedStatement ps1 = con.prepareStatement("insert into umts_table (pro_id) Values ( '"+ id+"' )");
                ps1.executeUpdate();
                ps.close();
        }else if(projectModel.getGen().startsWith("4")){
            PreparedStatement ps1 = con.prepareStatement("insert into lte_table (pro_id) Values ( '"+ id+"' )");
            ps1.executeUpdate();
            ps.close();
        }
        con.commit();
        ProjectModel newProject = new ProjectModel(projectModel.getName(),projectModel.getGen(),""+id);
        return newProject;
    }

    //return list of all projects
    public ArrayList<ProjectModel> getAllProjects() throws SQLException {
        ArrayList<ProjectModel> list = new ArrayList<ProjectModel>();
        ResultSet rs = con.prepareStatement("Select * from project").executeQuery();
        while (rs.next()){
            list.add(new ProjectModel(rs.getString("name"),rs.getString("gen"),rs.getString("id")));
        }
        return list;
    }
}
