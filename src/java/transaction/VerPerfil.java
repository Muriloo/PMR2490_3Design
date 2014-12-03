/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;


import utils.*;
import user.*;
import java.util.*;
import project.projectData;
/**
 *
 * @author Yuji
 */
public class VerPerfil {
   
    
    public Vector getCustomerInfo(String id) {
     Transacao tr = new Transacao();
     try {
        tr.beginReadOnly();
           userDATA udata = new userDATA();
           Vector v = udata.getCustomerInfo(tr, id);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por todos os Perfis");
         e.printStackTrace();
     }
     return null;
  } // pesquisar
    
     public Vector getCustomerProjectInfo(String id) {
     Transacao tr = new Transacao();
     try {
        tr.beginReadOnly();
           userDATA udata = new userDATA();
           Vector v = udata.getCustomerProjectInfo(tr, id);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por todos os Perfis");
         e.printStackTrace();
     }
     return null;
  } // pesquisar

}
