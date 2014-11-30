/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import utils.*;
import data.*;
import java.util.*;
/**
 *
 * @author Arthur
 */
public class UserTransactions {

 
  public Vector getAllUsers() {
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           ContatoData cdata = new ContatoData();
           Vector v = cdata.buscarTodos(tr);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por projetos pendentes");
         e.printStackTrace();
     }
     return null;
  } // pesquisar

  
  
  public Vector getUser(Vector info) {
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           ContatoData cdata = new ContatoData();
           Vector v = cdata.buscarId(info, tr);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por projetos pendentes");
         e.printStackTrace();
     }
     return null;
  } // pesquisar

  


}//pendingProject
