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
import java.text.SimpleDateFormat;

import java.util.*;
import user.*;
import utils.Transacao;
import java.text.SimpleDateFormat;

import cart.*;


public class projectData {
   
    public void approve(versionDO version, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     Date dia = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
     sdf.format(dia);
     String day= sdf.format(dia);
     String sql1 = "update version set version_status_id=1, updated_at=? where version_status_id=2 and version_project_id=? and id=?;";
     String sql2 = "update version set version_visibility=0, updated_at=? where version_visibility=1 and version_project_id=?;";
     String sql3 = "update version set version_visibility=1, updated_at=? where version_project_id=? and id=?;";
     int projId = version.getProjectId();
     int versId = version.getId();
     PreparedStatement ps1 = con.prepareStatement(sql1);
     ps1.setString (1, day);
     ps1.setInt(2, projId);
     ps1.setInt(3, versId);
     PreparedStatement ps2 = con.prepareStatement(sql2);
     ps2.setString (1, day);
     ps2.setInt(2, projId);
     PreparedStatement ps3 = con.prepareStatement(sql3);
     ps3.setString (1, day);
     ps3.setInt(2, projId);
     ps3.setInt(3, versId);

     System.out.println("projID="+projId+"versID="+versId);
 
     int result = ps1.executeUpdate();
     result = ps2.executeUpdate();
     result = ps3.executeUpdate();
  } // approve version whose status is "pending"(status_id=2), i.e. set status_id = 1
  
    public void reprove(versionDO version, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     Date dia = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
     sdf.format(dia);
     String day= sdf.format(dia);
     String sql = "update version set version_status_id=3, updated_at=? where version_status_id=2"
             + " and version_project_id=? and id=?;\n";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString (1, day);
     ps.setInt(2, version.getProjectId());
     ps.setInt(3, version.getId());
	
     int result = ps.executeUpdate();
  } // reprove version whose status is "pending"(status_id=2), i.e. set status_id = 3

    public Vector getPending(Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from version where version_status_id=2 and deleted=0";
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
        v.setFilepath(rs.getString("version_file"));
           
        pendingVersions.add(v);
     }
     return pendingVersions;
  } // gets versions with "pending" status
   

    public void uploadProject(projectDO project, versionDO version, ArrayList<ImageDO> images, Transacao tr) throws Exception{
        
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
           
            String query_version = "insert into version (version_name, version_visibility, version_status_id, "
                    + "version_file, version_project_id,updated_at) values ('1.0',0,2,'"+version.getFilepath()+"',"
                    + project_id+ ",'"+now_str+"')";
            
            Statement stmt_version = con.createStatement();
            // Obtain the generated key that results from the query.
            stmt_version.executeUpdate(query_version, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs_version = stmt_version.getGeneratedKeys();
            if ( rs_version.next() ) {
                // Retrieve the auto generated key(s).
                int version_id = rs_version.getInt(1);
                String query_image;
                for (ImageDO this_imageLink : images) {
                    query_image = "insert into image (image_link, "
                    + "image_version_id,updated_at) values ('"+this_imageLink.getImagelink()+"',"
                    + version_id+ ",'"+now_str+"');";
                    Statement stmt_image = con.createStatement();
                    stmt_image.executeUpdate(query_image);
                    
                }
                
            
                
                
            }
            
        }
        
    }
    
     public Vector getAllProjects(Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from project";
     PreparedStatement ps = con.prepareStatement(sql);
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector projetos = new Vector();
     while (rs.next()) {
        projectDO v = new projectDO();
        v.setId (rs.getInt("id"));
        v.setName (rs.getString("project_name"));
        System.out.println(" got " + v.getName());
        v.setStatusId(rs.getInt("project_status_id"));
        v.setPrice(rs.getInt("project_price"));
           
        projetos.add(v);
     }
     return projetos;
  } // gets versions with "pending" status
    
     
     
    public Vector getCartProjects(Vector items, Transacao tr) throws Exception {
    Connection con = tr.obterConexao();    
    Vector projetos = new Vector();
    for(int i = 0; i < items.size(); i++) {
        cartDO item = (cartDO)items.elementAt(i);
        String sql = "select * from project where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, item.getProjectId());
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        while (rs.next()) {
           projectDO v = new projectDO();
           v.setId (rs.getInt("id"));
           v.setName (rs.getString("project_name"));
           System.out.println(" got " + v.getName());
           v.setPrice(rs.getInt("project_price"));
           projetos.add(v);
        }
     }
     return projetos;
  } // gets versions with "pending" status
    

    public void editProject(projectDO project, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        sdf.format(now);
        String now_str = sdf.format(now);
        String sql = "update project set project_name = ?, project_description = ?, project_price = ?, updated_at = ? where id = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, project.getName());
        ps.setString(2, project.getDescription());
        ps.setFloat(3, project.getPrice());
        ps.setString(4, now_str);
        ps.setInt(5, project.getId());
        int result = ps.executeUpdate();
    }
    
    public void deleteProject(projectDO project, Transacao tr) throws Exception {
       Connection con = tr.obterConexao();
       Date now = new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
       sdf.format(now);
       String now_str = sdf.format(now);
       String sql = "update project set deleted = 1, deleted_at = ? where id = ?;";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setString(1, now_str);
       ps.setInt(2, project.getId());
       int result = ps.executeUpdate();   
    }

}
