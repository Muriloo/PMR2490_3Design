/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;
import java.sql.*;
import java.util.*;
import utils.Transacao;
import java.text.SimpleDateFormat;
import java.util.Date;
import comment.*;
/**
 *
 * @author Mauri
 */
public class ContatoData {
    
    public void incluir(ContatoDO contato, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     Date dia = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
     sdf.format(dia);
     String day= sdf.format(dia);
     String sql = "insert into customer (name, last_name,username, email, password, country, updated_at)"
             + " values (?, ?, ?, ?, ?, ?, ?)";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, contato.getNome());
     ps.setString(2, contato.getSobrenome());
     ps.setString(3, contato.getUsername());
     ps.setString(4, contato.getEmail());
     ps.setString(5, contato.getSenha());
     ps.setString(6, contato.getPais());
     ps.setString (7, day);
     int result = ps.executeUpdate();

  }
//
//  public void excluir(ContatoDO contato, Transacao tr) throws Exception {
//     excluir(contato.getId(), tr);
//  } // excluir
//
//  public void excluir (int idobj, Transacao tr) throws Exception {
//  } // excluir 
//
//  public void atualizar(ContatoDO contato, Transacao tr) throws Exception {
//     Connection con = tr.obterConexao();
//     String sql = "update Agenda set nome=?, telefone=? where id=?";
//     PreparedStatement ps = con.prepareStatement(sql);
//     ps.setString(1, contato.getNome());
//     ps.setString(2, contato.getSobrenome());
//	 ps.setInt(3, contato.getId());
//     int result = ps.executeUpdate();
//  } // atualizar

      public Vector buscarTodos(Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from customer";
     PreparedStatement ps = con.prepareStatement(sql);
     ResultSet rs = ps.executeQuery();
     System.out.println("query executada");
     Vector busca = new Vector();
     while (rs.next()) {
        ContatoDO v = new ContatoDO();
        v.setEmail(rs.getString("email"));
        v.setUsername(rs.getString("username"));
        System.out.println(" got " + v.getUsername());           
        busca.add(v);
     }
     return busca;
  } // gets versions with "pending" status
  
  public ContatoDO buscarEmail(String email, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from customer where email=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, email);
     ResultSet rs = ps.executeQuery();
     rs.next();
     ContatoDO contato = new ContatoDO();
     contato.setEmail(rs.getString("email"));
     return contato;
  } // buscar
  
   public ContatoDO buscarUsername(String username, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from customer where username=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setString(1, username);
     ResultSet rs = ps.executeQuery();
     rs.next();
     ContatoDO contato = new ContatoDO();
     contato.setUsername(rs.getString("username"));
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
  
  
   public Vector buscarId(Vector comments, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();    
    Vector contatos = new Vector();
    for(int i = 0; i < comments.size(); i++) {
        CommentDO comment = (CommentDO)comments.elementAt(i);
        String sql = "select * from customer where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, comment.getCustomerId());
        System.out.println("Tentando achar usuario");
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        while (rs.next()) {
           ContatoDO v = new ContatoDO();
           v.setUsername (rs.getString("username"));
           System.out.println(" got " + v.getUsername());
           contatos.add(v);
        }
     }
     return contatos;             
  } // buscar
   
  public ContatoDO buscarUsernameInt(int customerId, Transacao tr) throws Exception {
     Connection con = tr.obterConexao();
     String sql = "select * from customer where id=?";
     PreparedStatement ps = con.prepareStatement(sql);
     ps.setInt(1, customerId);
     ResultSet rs = ps.executeQuery();
     rs.next();
     ContatoDO contato = new ContatoDO();
     contato.setUsername(rs.getString("username"));
     System.out.println("got " +  contato);
     return contato;
  } // pesquisa o username
}
