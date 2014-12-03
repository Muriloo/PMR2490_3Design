/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import utils.Transacao;

/**
 *
 * @author Eduardo Seiti
 */
public class dadosdevendaData {
    
    public Vector buscaVendas(Transacao tr, int CustId) throws Exception { // busca os projetos de um id
        Connection con = tr.obterConexao();
        System.out.println("Entra na busca");
        String sql = "SELECT Sum(order_item_quantity) "
                + "as Sold_quantity, sum(order_item_unit_price) "
                + "as Sold_total, p.project_name, p.project_status_id, p.id "
                + "FROM  order_item oi "
                + "inner join project p on p.id = oi.project_id "
                + "where p.customer_id=? "
                + "group by oi.project_id";
               PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, CustId);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector Vendas = new Vector();
        
        while(rs.next()){
            dadosdevendaDO p = new dadosdevendaDO();
            p.setSold_total (rs.getFloat("Sold_quantity"));
            p.setSold_quantity (rs.getInt("Sold_total"));
            p.setProject_name (rs.getString("project_name"));
            p.setProject_status_id(rs.getInt("project_status_id"));
            p.setId(rs.getInt("id"));
            System.out.println("got project_id" );
            Vendas.add(p);
        
        }
        System.out.println("dadosdevendaData - retorna projetos vendidos");
        return Vendas;
        
  } // get project from customer
    
}
