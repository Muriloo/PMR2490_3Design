/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import user.userDO;
import user.userDATA;
import utils.Transacao;

/**
 *
 * @author Yuji
 */
public class EditarPerfil {
        public boolean editarPerfil(userDO user) throws Exception{
        
        Transacao tr = new Transacao();
            try {
                tr.begin();
                    userDATA udata = new userDATA();
                    udata.editCustomer(user, tr);
                tr.commit();
                return true;
                
            } catch(Exception e) {
                tr.rollback();
                System.out.println("erro ao editar perfil " + user.getName());
                e.printStackTrace();
            }
            return false;
            
    }
}
