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
    
    public supplierDO update (supplierDO supplier) throws Exception {
       Transacao tr = new Transacao(); 
       try{ 
            System.out.println("1entra no try");
            supplierData sdata = new supplierData();
            System.out.println("2 data");
            Vector addresses = supplier.getAddress();
            System.out.println("3.getAddress");
            Vector contacts = supplier.getContactInfo();
                    System.out.println("4.getContact info");
            Vector banks = supplier.getBankInfo();
            System.out.println("5get bank info");
            int Aid = supplier.getId();
            System.out.println("6get ID");
            sdata.update(supplier, tr);
            System.out.println("7fez update");
            if (addresses != null){
                
                for (int i=0;i<addresses.size();i++){
                supplierAddressDO address = (supplierAddressDO) addresses.elementAt(i);
                Aid = sdata.insertAddress(address, tr);
                address.setId(Aid);
                addresses.add(i,address);
            }
            supplier.setAddress(addresses);
            }
            if (contacts != null){
                for (int i=0;i<contacts.size();i++){
                contactInfoDO contact = (contactInfoDO) contacts.elementAt(i);
                Aid = sdata.insertContact(contact, tr);
                contact.setId(Aid);
                contacts.add(i,contact);
                }
                supplier.setContactInfo(contacts);
            }
         if (banks != null){
             for (int i=0;i<banks.size();i++){
                 BankInfoDO bank = (BankInfoDO) banks.elementAt(i);
                 Aid = sdata.insertBank(bank, tr);
                 bank.setId(Aid);
                 banks.add(i,bank);
             }
              System.out.println("antes de bank");
             supplier.setBankInfo(banks);
         }
          System.out.println("antes de commitar");
       tr.commit();
       System.out.println("pois de commitar");
       return supplier;
       
     } catch(Exception e) {
             System.out.println("cai no catch");
         tr.rollback();
         System.out.println("erro ao editar " + supplier.getName());
         e.printStackTrace();
     }
     supplierDO nada = new supplierDO();
     nada.setId(-1);
     return nada;
    }
    
    public supplierDO include (supplierDO supplier) throws Exception {
       Transacao tr = new Transacao(); 
       
       try{ 
       tr.begin();  
         supplierData sdata = new supplierData();
         Vector addresses = supplier.getAddress();
         Vector contacts = supplier.getContactInfo();
         Vector banks = supplier.getBankInfo();
         // verificação geral
         int Aid=sdata.include(supplier, tr);
         supplier.setId(Aid);
         if (addresses != null){
             System.out.println(addresses.size());
             for (int i=0;i<addresses.size();i++){
                System.out.println("dentro do for iteração i="+i); 
                 supplierAddressDO address = (supplierAddressDO) addresses.elementAt(i);
                 Aid = sdata.insertAddress(address, tr);
                 address.setId(Aid);
                 addresses.add(i,address);
             }
             supplier.setAddress(addresses);
         }
         if (contacts != null){
             for (int i=0;i<contacts.size();i++){
                 contactInfoDO contact = (contactInfoDO) contacts.elementAt(i);
                 Aid = sdata.insertContact(contact, tr);
                 contact.setId(Aid);
                 contacts.add(i,contact);
             }
             supplier.setContactInfo(contacts);
         }
         if (banks != null){
             for (int i=0;i<banks.size();i++){
                 BankInfoDO bank = (BankInfoDO) banks.elementAt(i);
                 Aid = sdata.insertBank(bank, tr);
                 bank.setId(Aid);
                 banks.add(i,bank);
             }
             supplier.setBankInfo(banks);
         }
          
       tr.commit();
       return supplier;
       
     } catch(Exception e) {
         System.out.println("cai no catch");
         tr.rollback();
         System.out.println("erro ao incluir " + supplier.getName());
         e.printStackTrace();
     }
     supplierDO nada = new supplierDO();
     nada.setId(-1);
     return nada;
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
