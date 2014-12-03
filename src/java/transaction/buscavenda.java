package transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Vector;
import project.projectData;
import utils.Transacao;
import order.orderitemData;
import data.ContatoData;
import utils.Transacao;
import data.ContatoDO;
import order.orderitemData;
import order.dadosdevendaData;

/**
 *
 * @author Mari
 */
public class buscavenda {
    
    public Vector getCustProject(int CustId) { //pesquisa projetos do customer
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           orderitemData oiData = new orderitemData();
           Vector p = oiData.getProject(tr,CustId);
		 tr.commit();
                 System.out.println("buscavenda - comita");
                 return p;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar projeto do customer ");
         e.printStackTrace();
     }
     return null;
  } // pesquisa projeto do customer 
    
     public ContatoDO getCustName(int CustId) { //pesquisa nome do customer
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           ContatoData cData = new ContatoData();
           //data.ContatoDO nome = cData.buscarNome(CustId, tr);
		 tr.commit();
                 System.out.println("buscavenda getCustName - comita");
                 //return nome;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar projeto do customer ");
         e.printStackTrace();
     }
     return null;
  } // pesquisa nome do customer
    
     public ContatoDO getCustUsername(int CustId) { //pesquisa username do customer
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           ContatoData cData = new ContatoData();
           data.ContatoDO nome = cData.buscarUsernameInt(CustId, tr);
		 tr.commit();
                 System.out.println("buscavenda get CustUsername - comita");
                 return nome;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar projeto do customer ");
         e.printStackTrace();
     }
     return null;
  } // pesquisa username do customer
     
     public Vector getProjOI(int Project) { //pesquisa orderitem do projeto
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           orderitemData ioData = new orderitemData();
           Vector orderitem = ioData.getOrderItem(tr, Project);
		 tr.commit();
                 System.out.println("buscavenda getProjOI - comita");
                 return orderitem;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar projeto do customer ");
         e.printStackTrace();
     }
     return null;
  } // pesquisa orderitem do projeto
     
    public Vector getSold(int CustId) { //pesquisa vendas
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           dadosdevendaData dvData = new dadosdevendaData();
           Vector Vendas = dvData.buscaVendas(tr, CustId);
		 tr.commit();
                 System.out.println("buscavenda getVendas - comita");
                 return Vendas;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar vendas ");
         e.printStackTrace();
     }
     return null;
  } // pesquisa vendas
    
    public String VerifStatus(int statusId){
        if(statusId == 1){ //
            return "Aprovado";
        }else{
            if(statusId == 2){
                return "Aguardando";
            }else{
                if(statusId == 3){
                    return "Reprovado";
                }else{
                    return "Erro";
                }
            }
        }
    }// verifica status     
 
}
