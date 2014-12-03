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
import project.userInfoDO;
import utils.Transacao;

public class searchUserData {

    public Vector searchUser(Transacao tr, String keyword) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from customer where upper(name) like ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, "%"+keyword+"%");
     ResultSet rs = ps.executeQuery();
     Vector userInfo = new Vector();
     while (rs.next()) {
        userInfoDO s = new userInfoDO();
        s.setId (rs.getInt("id"));
        s.setUsername(rs.getString("username"));
        s.setEmail(rs.getString("email"));
        s.setCountry(rs.getString("country"));
        
        userInfo.add(s);
     }
     return userInfo;
    } // gets users
}// searchUserData