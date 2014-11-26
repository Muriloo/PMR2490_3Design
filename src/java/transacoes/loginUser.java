/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacoes;

import utils.*;
import data.*;
import java.util.*;

/**
 *
 * @author Mauri
 */
public class loginUser {
    public LoginUserDO buscarUsernameSenha(String username) throws Exception{
     Transacao tr = new Transacao();
     try{
	   tr.beginReadOnly();
  	     LoginUserData cdata = new LoginUserData();
	     LoginUserDO user = cdata.buscarUsername(username, tr);	 
           tr.commit();
	   return user;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar " + username);
	   e.printStackTrace();
	 }
	 return null;
  } // buscar
   
}
