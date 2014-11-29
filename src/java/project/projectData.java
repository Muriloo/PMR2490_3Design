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
import java.text.SimpleDateFormat;
import java.util.*;
import utils.Transacao;


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
        v.setFile(rs.getString("version_file"));
           
        pendingVersions.add(v);
     }
     return pendingVersions;
  } // gets versions with "pending" status
   

    
}
