/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.sql.*;
import java.util.*;
import utils.Transacao;
/**
 *
 * @author Mauri
 */
public class ContatoData {
    public void incluir(ContatoDO contato, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "insert into customer (name, last_name,username, email, passaword, country,created_at, updated_at)"
             + " values (?, ?, ?, ?, ?, ?, ?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, contato.getNome());
     ps.setString(2, contato.getSobrenome());
     ps.setString(3, contato.getUsername());
     ps.setString(4, contato.getEmail());
     ps.setString(5, contato.getSenha());
     ps.setString(6, contato.getPais());
     ps.setTime(7, null );
     ps.setDate(8, null);
     int result = ps.executeUpdate();

  }

  public void excluir(ContatoDO contato, Transacao tr) throws Exception {
     excluir(contato.getId(), tr);
  } // excluir

  public void excluir (int idobj, Transacao tr) throws Exception {
  } // excluir 

  public void atualizar(ContatoDO contato, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "update Agenda set nome=?, telefone=? where id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, contato.getNome());
     ps.setString(2, contato.getSobrenome());
	 ps.setInt(3, contato.getId());
     int result = ps.executeUpdate();
  } // atualizar

  public ContatoDO buscar(int idobj, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Agenda where  id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, idobj);
     ResultSet rs = ps.executeQuery();
     rs.next();
     ContatoDO contato = new ContatoDO();
     contato.setId (rs.getInt("id"));
     contato.setNome (rs.getString("nome"));
     contato.setSobrenome(rs.getString("telefone"));
     return contato;
  } // buscar

  public Vector pesquisarPorNome(String nome, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from Agenda where nome like ?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, nome);
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector contatos = new Vector();
     while (rs.next()) {
        ContatoDO c = new ContatoDO();
        c.setId (rs.getInt("id"));
        c.setNome (rs.getString("nome"));
        System.out.println(" got " + c.getNome());
//        c.setSobrenome(rs.getString("telefone"));
        contatos.add(c);
     }
     return contatos;
  } // pesquisarPorNome
}
