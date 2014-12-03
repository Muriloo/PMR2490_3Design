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
        String sql = "SELECT \n" +
            "SUM(order_item_quantity) AS Sold_quantity,\n" +
            "SUM(order_item_unit_price) AS Sold_total,\n" +
            "p.project_name,\n" +
            "p.project_status_id\n" +
            "FROM  3design.order_item oi \n" +
            "INNER JOIN project p ON p.id = oi.project_id \n" +
            "GROUP BY oi.project_id;";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, CustId);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector Vendas = new Vector();
        
        while(rs.next()){
            dadosdevendaDO p = new dadosdevendaDO();
            p.setSoldTotal (rs.getFloat("Sold_quantity"));
            p.setSoldQuantity (rs.getInt("Sold_total"));
            p.setProject_name (rs.getString("project_name"));
            System.out.println("got project_id" );
            Vendas.add(p);
        
        }
        System.out.println("orderitemData - retorna customer projects");
        return Vendas;
        
  } // get project from customer
    
}
