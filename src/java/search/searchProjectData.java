/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author Marcel
 */

import java.sql.*;
import java.util.*;
import project.projectDO;
import utils.Transacao;

public class searchProjectData {

    public Vector searchProject(Transacao tr, String keyword) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from project where upper(project_name) like ? and deleted=0";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, "%"+keyword+"%");
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector projectResults = new Vector();
     while (rs.next()) {
        projectDO v = new projectDO(rs.getString("project_name"),rs.getString("project_description"),rs.getString("project_detail"), rs.getFloat("project_price"),rs.getInt("id"));          
        v.setCustomerId(rs.getInt("customer_id"));
        projectResults.add(v);
     }
     return projectResults;
  } // gets project list

    
}
