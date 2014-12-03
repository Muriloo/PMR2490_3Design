/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import utils.*;
import cart.*;
import java.util.*;
/**
 *
 * @author Arthur
 */
public class CartTransactions {

 
  public Vector getItems(String customerId) {
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           cartData cdata = new cartData();
           Vector v = cdata.getItems(customerId, tr);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao procurar itens no carrinho");
         e.printStackTrace();
     }
     return null;
  } // pesquisar
  
      public boolean addItem (cartDO item) throws Exception{

     // validacao das regras de negocio
     if ( (item.getProjectId() == 0) || ( item.getQuantity() < 1) ) {
       return false;
     }

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {
       tr.begin();
         cartData cdata = new cartData();
         cdata.addItem(item, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao adicionar " + item.getProjectId());
         e.printStackTrace();
     }
     return false;
  } // approve project
  

      public boolean removeItem (cartDO item) throws Exception{

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {
       tr.begin();
         cartData cdata = new cartData();
         cdata.removeItem(item, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao remover " + item.getId());
         e.printStackTrace();
     }
     return false;
  } // approve project
  
      
      public boolean updateItem (cartDO item) throws Exception{

     // validacao das regras de negocio
     if ( (item.getId() == 0) || ( item.getQuantity() < 1) ) {
       return false;
     }

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {
       tr.begin();
         cartData cdata = new cartData();
         cdata.updateItem(item, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao atualizar " + item.getProjectId());
         e.printStackTrace();
     }
     return false;
  } // approve project
 

      public boolean removeAllItem (int customerId) throws Exception{

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {
       tr.begin();
         cartData cdata = new cartData();
         cdata.removeAllItem(customerId, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         //System.out.println("erro ao remover " + item.getId());
         e.printStackTrace();
     }
     return false;
  } // approve project


}//pendingProject
