/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import utils.*;
import project.*;
import java.util.*;
/**
 *
 * @author Marcel
 */
public class searchProject {
    
  public Vector getResults(String keyword) {
     
    Transacao tr = new Transacao();
    System.out.println("cria transação");
    try {
         
        System.out.println("entra no try");
        tr.beginReadOnly();
        searchProjectData pdata = new searchProjectData();
        Vector v = pdata.searchProject(tr, keyword);
        tr.commit();
        return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por projetos pendentes");
         e.printStackTrace();
     }
     return null;
  } // pesquisar


}//searchProject
