/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import project.*;
import utils.*;
import user.*;

/**
 *
 * @author Yuji
 */
public class EditarProjeto {
    
    public boolean editarProjeto(projectDO project) throws Exception{
        
        Transacao tr = new Transacao();
            try {
                tr.begin();
                    projectData pdata = new projectData();
                    pdata.editProject(project, tr);
                tr.commit();
                return true;
                
            } catch(Exception e) {
                tr.rollback();
                System.out.println("erro ao gravar projeto " + project.getName());
                e.printStackTrace();
            }
            return false;
            
    }
    
}
