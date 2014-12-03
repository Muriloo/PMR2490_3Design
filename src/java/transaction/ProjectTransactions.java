/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import utils.*;
import project.*;
import java.util.*;
/**
 *
 * @author Arthur
 */
public class ProjectTransactions {
  
    public Vector getAllProjects() {
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           projectData pdata = new projectData();
           Vector v = pdata.getAllProjects(tr);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por todos os projetos");
         e.printStackTrace();
     }
     return null;
  } // pesquisar
    
    
    public Vector getCartProjects(Vector items) {
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           projectData pdata = new projectData();
           Vector v = pdata.getCartProjects(items, tr);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por projetos do carrinho");
         e.printStackTrace();
     }
     return null;
  } // pesquisar

public Vector getProjectInfo(String id) {
     Transacao tr = new Transacao();
     try {
        tr.beginReadOnly();
           projectData pdata = new projectData();
           Vector v = pdata.getProjectInfo(tr, id);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por todos os projetos");
         e.printStackTrace();
     }
     return null;
  } // pesquisar


}//pendingProject
