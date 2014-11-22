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
public class pendingProject {
      public boolean approve (versionDO ver) throws Exception{

     // validacao das regras de negocio
     if ( (isEmpty(ver.getName())) || ( ver.getStatusId()!=2) ) {
       return false;
     }

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {

       tr.begin();
         projectData pdata = new projectData();
         pdata.approve(ver, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao aprovar " + ver.getName());
         e.printStackTrace();
     }
     return false;
  } // approve project

 public boolean reprove (versionDO ver) throws Exception{

     // validacao das regras de negocio
     if ( (isEmpty(ver.getName())) || ( ver.getStatusId()!=2) ) {
       return false;
     }

     // efetuando a transacao
     Transacao tr = new Transacao();
     try {

       tr.begin();
         projectData pdata = new projectData();
         pdata.reprove(ver, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao reprovar " + ver.getName());
         e.printStackTrace();
     }
     return false;
  } // reprove project
 
  public Vector getPending() {
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           projectData pdata = new projectData();
           Vector v = pdata.getPending(tr);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por projetos pendentes");
         e.printStackTrace();
     }
     return null;
  } // pesquisar

  private boolean isEmpty(String s) {
     if (null == s)
       return true;
     if (s.length() == 0)
       return true;
     return false;
  }


}//pendingProject
