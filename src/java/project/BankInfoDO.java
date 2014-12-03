/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.Serializable;

/**
 *
 * @author Arthur
 */
public class BankInfoDO  implements Serializable{
    private int _id=-1;
    private int _supplier_id;
    private String _bank_number;
    private String _agency;
    private String _account;
    private String _cnpj_cpf;
    
    
    public void setId(int id){
_id = id;
}

public int getId(){
return _id;
}

public void setSupplierId(int id){
_supplier_id = id;
}

public int getSupplierId(){
return _supplier_id;
}
    
public void setBankNumber(String bank_number){
_bank_number = bank_number;
}

public String getBankNumber(){
return _bank_number;
}  

public void setAgency(String agency){
_agency = agency;
}

public String getAgency(){
return _agency;
}  

public void setAccount(String account){
_account = account;
}

public String getAccount(){
return _account;
}  

public void setCnpjCpf(String cnpj_cpf){
_cnpj_cpf = cnpj_cpf;
}

public String getCnpjCpf(){
return _cnpj_cpf;
}  
}

