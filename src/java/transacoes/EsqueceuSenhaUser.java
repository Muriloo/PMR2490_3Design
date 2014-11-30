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
 * @author Bobrow
 */
public class EsqueceuSenhaUser {
    public LoginUserDO buscarUsernameEmail(String email) throws Exception{
     Transacao tr = new Transacao();
     try{
	   tr.beginReadOnly();
  	     EsqueceuSenhaData cdata = new EsqueceuSenhaData();
	     LoginUserDO user = cdata.buscarEmail(email, tr);	 
           tr.commit();
	   return user;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao buscar " + email);
	   e.printStackTrace();
	 }
	 return null;
  } // buscar
   
}
