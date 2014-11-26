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
 * @author Paulo
 */
//public class Contato {
//     public boolean incluir (ContatoDO contato) throws Exception{
//     
//     if ( (isEmpty(contato.getNome())) || ( isEmpty(contato.getSobrenome())) || ( isEmpty(contato.getUsername())) 
//     || ( isEmpty(contato.getEmail())) || ( isEmpty(contato.getSenha())) || ( isEmpty(contato.getPais()))   ) {
//        return false;
//     }
//
//     // efetuando a transacao
//     Transacao tr = new Transacao();
//     try {
//       tr.begin();
//         ContatoData cdata = new ContatoData();
//         cdata.incluir(contato, tr);
//       tr.commit();
//       return true;
//       
//     } catch(Exception e) {
//         tr.rollback();
//         System.out.println("erro ao incluir " + contato.getNome());
//         System.out.println("erro ao incluir " + contato.getSobrenome());
//         System.out.println("erro ao incluir " + contato.getUsername());
//         System.out.println("erro ao incluir " + contato.getEmail());
//         System.out.println("erro ao incluir " + contato.getSenha());
//         System.out.println("erro ao incluir " + contato.getPais());
//         
//         e.printStackTrace();
//     }
//     return false;
//  } // incluir

  public boolean atualizar(ContatoDO contato) throws Exception {
     Transacao tr = new Transacao();
	 try{
	   // inserir validacoes de regras de negocio
	   tr.begin();
  	     ContatoData cdata = new ContatoData();
	     cdata.atualizar(contato, tr);
	   tr.commit();
	   return true;
	 } catch (Exception e) {
	   tr.rollback();
	   System.out.println("erro ao atualizar" + contato.getNome());
	   e.printStackTrace();
	 }
	 return false;
  } // atualizar
//
//  public boolean buscarEmail(String email) throws Exception{
//     Transacao tr = new Transacao();
//	 try{
//	   tr.beginReadOnly();
//  	     ContatoData cdata = new ContatoData();
//	     ContatoDO c = cdata.buscarEmail(email, tr);
//	   tr.commit();
//	   return true;
//	 } catch (Exception e) {
//	   tr.rollback();
//	   System.out.println("erro ao buscar" + email);
//	   e.printStackTrace();
//	 }
//	 return false;
//  } // buscar
//  
//   public boolean buscarUsername(String username) throws Exception{
//     Transacao tr = new Transacao();
//	 try{
//	   tr.beginReadOnly();
//  	     ContatoData cdata = new ContatoData();
//	     ContatoDO c = cdata.buscarUsername(username, tr);
//	   tr.commit();
//	   return true;
//	 } catch (Exception e) {
//	   tr.rollback();
//	   System.out.println("erro ao buscar" + username);
//	   e.printStackTrace();
//	 }
//	 return false;
//  } // buscar
//
//  public Vector pesquisar(String nome) {
//     if ( isEmpty(nome) )
//        return null;
//
//     Transacao tr = new Transacao();
//     try {
//	     tr.beginReadOnly();
//           ContatoData cdata = new ContatoData();
//           Vector v = cdata.pesquisarPorNome(nome, tr);
//		 tr.commit();
//		 return v;
//     } catch(Exception e) {
//         System.out.println("erro ao pesquisar " + nome);
//         e.printStackTrace();
//     }
//     return null;
//  } // pesquisar

  private boolean isEmpty(String s) {
     if (null == s)
       return true;
     if (s.length() == 0)
       return true;
     return false;
  }

//  public static void main(String[] args) {
//      Contato c = new Contato();
//      ContatoDO contato = new ContatoDO();
//      try {
//	    contato = c.buscar(6);
//		System.out.println(contato.getNome());
//      } catch(Exception e) {
//          e.printStackTrace();
//      }
//  } // main
}
