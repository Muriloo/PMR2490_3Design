/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Arthur
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import utils.Transacao;
import java.text.SimpleDateFormat;


public class projectData {
   
    
    public void trocarsenha (String senha, String username, Transacao tr)throws Exception {
     Connection con = tr.obterConexao();
     String sql = "update customer set password=? where username=?;";

     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, senha);
     ps.setString(2, username);

     System.out.println("senha alterada com sucesso");
 
     
    
     int result = ps.executeUpdate();
     System.out.println(result);   
     
    }
    
    
    
  public void approve(versionDO version, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql1 = "update version set version_status_id=1 where version_status_id=2 and version_project_id=? and id=?;";
     String sql2 = "update version set version_visibility=0 where version_visibility=1 and version_project_id=?;";
     String sql3 = "update version set version_visibility=1 where version_project_id=? and id=?;";
     int projId = version.getProjectId();
     int versId = version.getId();
     PreparedStatement ps1 = con.prepareStatement(sql1);
     ps1.setInt(1, projId);
     ps1.setInt(2, versId);
     PreparedStatement ps2 = con.prepareStatement(sql2);
     ps2.setInt(1, projId);
     PreparedStatement ps3 = con.prepareStatement(sql3);
     ps3.setInt(1, projId);
     ps3.setInt(2, versId);

     System.out.println("projID="+projId+"versID="+versId);
 
     int result = ps1.executeUpdate();
     result = ps2.executeUpdate();
     result = ps3.executeUpdate();
  } // approve version whose status is "pending"(status_id=2), i.e. set status_id = 1
  
public void reprove(versionDO version, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "update version set version_status_id=3 where version_status_id=2"
             + " and version_project_id=? and id=?;\n";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, version.getProjectId());
     ps.setInt(2, version.getId());
	
     int result = ps.executeUpdate();
  } // reprove version whose status is "pending"(status_id=2), i.e. set status_id = 3

    public Vector getPending(Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from version where version_status_id=2";
     PreparedStatement ps = con.prepareStatement(sql);
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector pendingVersions = new Vector();
     while (rs.next()) {
        versionDO v = new versionDO();
        v.setId (rs.getInt("id"));
        v.setName (rs.getString("version_name"));
        System.out.println(" got " + v.getName());
        v.setVisibility(rs.getInt("version_visibility"));
        v.setProjectId(rs.getInt("version_project_id"));
        v.setStatusId(rs.getInt("version_status_id"));
           
        pendingVersions.add(v);
     }
     return pendingVersions;
  } // gets versions with "pending" status

    public void uploadProject(projectDO project, versionDO version, Transacao tr) throws Exception{
        
        Connection con = tr.obterConexao();
        int project_id;
        int customer_id = 1;
        //create query statement
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        sdf.format(now);
        String now_str= sdf.format(now);
        
        String query_str = "INSERT INTO project (customer_id, project_name, project_description, "
                + "project_detail, project_status_id, project_price,updated_at) " +
                 "VALUES ("+customer_id+",'"+project.getName()+"','"+project.getDescription()
                + "','"+project.getDetail()+"',"+2+","+project.getPrice()+",'"+now_str+"')";
        
        Statement stmt = con.createStatement();
        // Obtain the generated key that results from the query.
        stmt.executeUpdate(query_str, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stmt.getGeneratedKeys();
        if ( rs.next() ) {
            // Retrieve the auto generated key(s).
            project_id = rs.getInt(1);
           
            String sql_version = "insert into version (version_name, version_visibility, version_status_id, "
                    + "version_file, version_project_id,updated_at) values (?,?,?,?,?,?)";

            PreparedStatement ps2 = con.prepareStatement(sql_version);
            ps2.setString(1, "1.0");
            ps2.setInt(2, 0);
            ps2.setInt(3, 2);//status pendente
            ps2.setBlob(4, version.getFile());
            ps2.setInt(5, project_id);
            ps2.setString(6, now_str);

            ps2.executeUpdate();
        }
        
    }
    
}
