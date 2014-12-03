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
public class searchUser {
    
  public Vector getResults(String keyword) {
     
    Transacao tr = new Transacao();
    try {
        tr.beginReadOnly();
        searchUserData pdata = new searchUserData();
        Vector v = pdata.searchUser(tr, keyword);
        tr.commit();
        return v;
     } catch(Exception e) {
        e.printStackTrace();
     }
     return null;
  } // pesquisar


}//searchSupplier
