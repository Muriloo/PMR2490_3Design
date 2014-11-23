/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import utils.Transacao;

/**
 *
 * @author Mauri
 */
public class LoginUserData {
    
    public LoginUserDO buscarUsername(String username, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from customer where username=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, username);
     ResultSet rs = ps.executeQuery();
     rs.next();
     LoginUserDO contato = new LoginUserDO();
     contato.setUsername(rs.getString("username"));
     contato.setSenha(rs.getString("password"));
     contato.setId(rs.getInt("id"));
     return contato;
  } // buscar
}
