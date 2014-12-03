/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

//import data.ContatoDO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import utils.Transacao;
//import project.projectDO;




/**
 *
 * @author Eduardo Seiti
 */
public class orderitemData {
    
    public Vector getProject(Transacao tr, int CustId) throws Exception { // busca os projetos de um id
        Connection con = tr.obterConexao();
        System.out.println("entra no orderitemdata get project");
        String sql = "select * from project where customer_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, CustId);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector CustomerProjects = new Vector();
        
        while(rs.next()){
            projectDO p = new projectDO();
            p.setId (rs.getInt("id"));
            p.setName (rs.getString("project_name"));
            p.setDescription (rs.getString("project_description"));
            p.setStatus_id (rs.getInt("project_status_id"));
            p.setDetail (rs.getString("project_detail"));
            p.setPrice (rs.getFloat("project_price"));
            //orderitemDO p = new orderitemDO();
            //p.setProject_id (rs.getInt("id"));
            System.out.println("got project_id" );
            CustomerProjects.add(p);
        
        }
        System.out.println("orderitemData - retorna customer projects");
        return CustomerProjects;
        
  } // get project from customer
    
    public Vector getOrderItem(Transacao tr, int Project) throws Exception { // busca o orderitem do projeto
        Connection con = tr.obterConexao();
        System.out.println("entra no orderitemdata pega order item");
        String sql = "select * from order_item where project_id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, Project);
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector OrderItem = new Vector();
        
        while(rs.next()){
            orderitemDO oi = new orderitemDO();
            oi.setId (rs.getInt("id"));
            oi.setOrder_id (rs.getInt("order_id"));
            oi.setProject_id (rs.getInt("project_id"));
            oi.setOrder_item_quantity (rs.getInt("order_item_quantity"));
            oi.setItem_unit_price (rs.getFloat("order_item_unit_price"));
            System.out.println("got order item" );
            OrderItem.add(oi);
        }
        System.out.println("orderitemData - retorna customer projects");
        return OrderItem;
        
  } // busca o orderitem do projeto
 /*       
    public projectDO buscarProjeto(String CustomerId, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();
        String sql = "select * from project where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, CustomerId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        projectDO project = new projectDO();
        project.setId(rs.getInt("CustomerId"));
        return project;
    } // buscar projeto   
*/
}
