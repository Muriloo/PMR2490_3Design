/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;
import project.*;
import utils.*;
import java.util.*;
/**
 *
 * @author Arthur
 */
public class supplier {
    
    public boolean include (supplierDO supplier) throws Exception {
       Transacao tr = new Transacao(); 
       try{ 
       tr.begin();
         supplierData sdata = new supplierData();
         sdata.include(supplier, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao incluir " + supplier.getName());
         e.printStackTrace();
     }
     return false;
    }
    
    public boolean delete (supplierDO supplier) throws Exception {
       Transacao tr = new Transacao(); 
       try{ 
       tr.begin();
         supplierData sdata = new supplierData();
         sdata.delete(supplier, tr);
       tr.commit();
       return true;
       
     } catch(Exception e) {
         tr.rollback();
         System.out.println("erro ao excluir " + supplier.getName());
         e.printStackTrace();
     }
     return false;
    }
    
    public Vector getSuppliers() {
     
     Transacao tr = new Transacao();
      System.out.println("cria transação");
     try {
         
         System.out.println("entra no try");
	     tr.beginReadOnly();
           supplierData sdata = new supplierData();
           Vector v = sdata.getSuppliers(tr);
		 tr.commit();
                 return v;
     } catch(Exception e) {
         System.out.println("erro ao pesquisar por fornecedores");
         e.printStackTrace();
     }
     System.out.println("fornecedores retornam null");
     return null;
  } // pesquisar por fornecedores

     
    
}
