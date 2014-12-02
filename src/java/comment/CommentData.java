/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comment;
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
public class CommentData {
  
    public Vector getComments(String projectId, Transacao tr) throws Exception {
        Connection con = tr.obterConexao();    
        String sql = "select * from comment where comment_project_id=? and deleted=0 order by created_at desc";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, projectId);
        System.out.println("antes da query");
        ResultSet rs = ps.executeQuery();
        System.out.println("query executada");
        Vector comments = new Vector();
        while (rs.next()) {
        System.out.println("ok aqui");
           CommentDO v = new CommentDO();
           v.setId (rs.getInt("id"));
           v.setCustomerId (rs.getInt("comment_customer_id"));
           v.setComment(rs.getString("comment"));
           v.setCreatedAt(rs.getString("created_at"));
           comments.add(v);
        }         
        return comments;             
    } // buscar
  
    
    
      
  public void addComment(CommentDO comment, Transacao tr) throws Exception {// adiciona comentário
     Connection con = tr.obterConexao();
     //cria item novo
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh-mm-ss");
        String now_str= sdf.format(now);

        String sql = "INSERT INTO comment (comment_customer_id, comment_project_id, `comment`, updated_at) VALUES (?,?,?,?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, comment.getCustomerId());
        ps.setInt(2, comment.getProjectId());
        ps.setString(3, comment.getComment());
        
        System.out.println(ps.toString());
        ps.setString(4, now_str);
        ps.executeUpdate();
  } // adiciona comentário
    
}
