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

import java.sql.*;
import java.util.*;
import utils.Transacao;


public class projectData {
   
  public void approve(versionDO version, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "update version set version_status_id=1 where version_status_id=2 and version_project_id=? and id=?;"
             + " update version set version_visibility=0 where version_visibility=1 and version_project_id=?;"
             + " update version set version_visibility=1 where version_project_id=? and id=?;";
     int projId = version.getProjectId();
     int versId = version.getId();
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, projId);
     ps.setInt(2, versId);
     ps.setInt(3, projId);
     ps.setInt(4, projId);
     ps.setInt(5, versId);
     System.out.println("projID="+projId+"versID="+versId);
 
     int result = ps.executeUpdate();
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

    
}
