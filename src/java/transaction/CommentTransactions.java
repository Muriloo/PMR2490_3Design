/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import utils.*;
import comment.*;
import java.util.*;
/**
 *
 * @author Arthur
 */
public class CommentTransactions {

 
  public Vector getComments(String projectId) {
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           CommentData cdata = new CommentData();
           Vector v = cdata.getComments(projectId, tr);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao procurar comentários");
         e.printStackTrace();
     }
     return null;
  } // pesquisar
  
  

      public boolean addComment (CommentDO comment) throws Exception{

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {
       tr.begin();
         CommentData cdata = new CommentData();
         cdata.addComment(comment, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao adicionar comentário");
         e.printStackTrace();
     }
     return false;
  } // approve project
  

}//pendingProject
