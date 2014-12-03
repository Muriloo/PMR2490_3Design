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
}
