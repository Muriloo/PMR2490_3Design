/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import utils.Transacao;
import java.text.SimpleDateFormat;
import project.projectDO;

/**
 *
 * @author Yuji
 */
public class userDATA {
    
    public void deleteUser(userDO user, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        sdf.format(now);
        String now_str = sdf.format(now);
        String sql = "update customer c inner join project p on p.customer_id = c.id set c.deleted = 1, p.deleted = 1, c.deleted_at = ?, p.deleted_at = ? where c.id = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(3, user.getId());
        ps.setString(1, now_str);
        ps.setString(2, now_str);
        int result = ps.executeUpdate();
    }

     public Vector getCustomerInfo(Transacao tr, String id) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from customer where id = ? and deleted = 0 ;";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString (1, id);
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector perfis = new Vector();
     while (rs.next()) {
         
        userDO v = new userDO();

        v.setId (rs.getInt("id"));
        v.setName (rs.getString("name"));
        v.setLastname(rs.getString("last_name"));
        v.setCountry(rs.getString("country"));
        
        perfis.add(v);
     }
     return perfis;   
    
    
    }
   
     public Vector getCustomerProjectInfo(Transacao tr, String id) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from project where customer_id = ?;";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString (1, id);
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector perfisprojeto = new Vector();
     while (rs.next()) {
         
        projectDO v = new projectDO(rs.getString("project_name"), rs.getInt("id"));

        v.setId (rs.getInt("id"));

        
        perfisprojeto.add(v);
     }
     return perfisprojeto;   
    
    
    }
     
        public void editCustomer(userDO user, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        sdf.format(now);
        String now_str = sdf.format(now);
        String sql = "update customer set name = ?, last_name = ?, username = ?,email = ?, updated_at = ?, country = ? where id = ?;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getName());
        ps.setString(2, user.getLastname());
        ps.setString(3, user.getUsername());
        ps.setString(4, user.getEmail());
        ps.setString(5, now_str);
        ps.setString(6, user.getCountry());
        ps.setInt(7, user.getId());
        int result = ps.executeUpdate();
    }
     
}
