/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transacoes;

import data.*;
import project.projectData;
import utils.Transacao;

/**
 *
 * @author 44RBO
 */
public class AlterarSenha {
    public boolean alterar (LoginUserDO alterar) throws Exception{
      Transacao tr = new Transacao();
        try {
            tr.begin();
            projectData pdata = new projectData();
            pdata.trocarsenha(alterar.getNovasenha1(),alterar.getUsername(), tr);
            tr.commit();
            return true;
        } // buscar
        catch (Exception e) {
            tr.rollback();
            System.out.println("erro ao buscar" + alterar.getNovasenha1());
            System.out.println("erro ao buscar" + alterar.getNovasenha2());
            e.printStackTrace();
        }
        return false;
    }
}

