/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;
import data.*;
import java.sql.*;
import java.util.*;
import utils.Transacao;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Mauri
 */
public class cartData {
    
    public Vector getItems(String customerId, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from item_cart where customer_id=? and deleted=0 order by created_at";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, customerId);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector items = new Vector();
        while (rs.next()) {
           cartDO v = new cartDO();
           v.setId(rs.getInt("id"));
           v.setCustomerId(rs.getInt("customer_id"));
           v.setProjectId(rs.getInt("project_id"));
           v.setQuantity(rs.getInt("quantity"));
           System.out.println(" got " + v.getCustomerId());           
           items.add(v);
        }
        return items;
    } // retorna em vetor os itens no carrinho do usuário
    
    
  public void addItem(cartDO item, Transacao tr) throws Exception {// adiciona ao carrinho se nao tiver item igual, se tiver aumenta a quantidade
     Connection con = tr.obterConexao();
        String sql = "select * from item_cart where customer_id=? and project_id=? and deleted=0";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, item.getCustomerId());
        ps.setInt(2, item.getProjectId());
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        ///*
        if(rs.next()){
            //aumenta a quantidade no numero selecionado
            int quantidade_inicial = rs.getInt("quantity");
            int quantidade_somada = item.getQuantity();
            int quantidade_final = quantidade_inicial + quantidade_somada;
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
            String now_str= sdf.format(now);

            String add_query = "update item_cart set quantity=? , updated_at=? where id=?;";
            PreparedStatement add_s = con.prepareStatement(add_query);
            add_s.setInt(1, quantidade_final);
            add_s.setString(2, now_str);
            add_s.setInt(3, rs.getInt("id"));

            add_s.executeUpdate();
        }else{
            //cria item novo
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
            String now_str= sdf.format(now);

            String new_str = "INSERT INTO item_cart (customer_id, project_id, quantity, updated_at) VALUES (?,?,?,?);";
            PreparedStatement new_s = con.prepareStatement(new_str);
            new_s.setInt(1,item.getCustomerId());
            new_s.setInt(2,item.getProjectId());
            new_s.setInt(3,item.getQuantity());
            new_s.setString(4,now_str);

            new_s.executeUpdate();
        }
                //*/
  } // adiciona ao carrinho se nao tiver item igual, se tiver aumenta a quantidade
    
  
public void removeItem(cartDO item, Transacao tr) throws Exception {//remove item do carrinho
    Connection con = tr.obterConexao();        
    //deleta item do carrinho
    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
    String now_str= sdf.format(now);

    String del_query = "update item_cart set deleted=1 , updated_at=? where id=?;";
    PreparedStatement del_s = con.prepareStatement(del_query);
    del_s.setString(1, now_str);
    del_s.setInt(2, item.getId());

    del_s.executeUpdate();
        
  } //remove item do carrinho
    

    
  public void updateItem(cartDO item, Transacao tr) throws Exception {// adiciona ao carrinho se nao tiver item igual, se tiver aumenta a quantidade
     Connection con = tr.obterConexao();
        String sql = "select * from item_cart where customer_id=? and id=? and deleted=0";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, item.getCustomerId());
        ps.setInt(2, item.getId());
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        ///*
        if(rs.next()){
            //aumenta a quantidade no numero selecionado
            Date now = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
            String now_str= sdf.format(now);

            String add_query = "update item_cart set quantity=? , updated_at=? where id=?;";
            PreparedStatement add_s = con.prepareStatement(add_query);
            add_s.setInt(1, item.getQuantity());
            add_s.setString(2, now_str);
            add_s.setInt(3, rs.getInt("id"));

            add_s.executeUpdate();
        }
                //*/
  } // adiciona ao carrinho se nao tiver item igual, se tiver aumenta a quantidade
public void removeAllItem(int customerId, Transacao tr) throws Exception {//remove item do carrinho
    Connection con = tr.obterConexao();        
    //deleta item do carrinho
    Date now = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
    String now_str= sdf.format(now);

    String del_query = "update item_cart set deleted=1 , updated_at=? where customer_id=?;";
    PreparedStatement del_s = con.prepareStatement(del_query);
    del_s.setString(1, now_str);
    del_s.setInt(2, customerId);

    del_s.executeUpdate();
        
  } //remove item do carrinho
        
} 
    



