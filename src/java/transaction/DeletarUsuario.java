/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import user.*;
import utils.*;
/**
 *
 * @author Yuji
 */
public class DeletarUsuario {
    
    public boolean deletarUsuarioMod (userDO user) throws Exception{
        
        Transacao tr = new Transacao();
            try {
                tr.begin();
                    userDATA udata = new userDATA();
                    udata.deleteUser(user, tr);
                    sendEmail semail = new sendEmail();
                    semail.deleteUserEmail(user.getEmail(),user.getName());
                tr.commit();
                return true;
                
            } catch(Exception e) {
                tr.rollback();
                System.out.println("erro ao deletar usuario " + user.getName());
                e.printStackTrace();
            }
            return false;
            
    }
    
    public boolean deletarUsuario (userDO user) throws Exception{
        
        Transacao tr = new Transacao();
            try {
                tr.begin();
                    userDATA udata = new userDATA();
                    udata.deleteUser(user, tr);
                tr.commit();
                return true;
                
            } catch(Exception e) {
                tr.rollback();
                System.out.println("erro ao deletar usuario " + user.getName());
                e.printStackTrace();
            }
            return false;
            
    }
}