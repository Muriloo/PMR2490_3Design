/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Arthur
 */
public class contactInfoDO {
    private int _id;
    private int _supplier_id;
    private String _name;
    private String _position;
    private String _email;
    private String _phone;
    
    
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
    
public void setName(String name){
_name = name;
}

public String getName(){
return _name;
}  

public void setPosition(String position){
_position = position;
}

public String getPosition(){
return _position;
}  

public void setEmail(String email){
_email = email;
}

public String getEmail(){
return _email;
}  

public void setPhone(String phone){
_phone = phone;
}

public String getPhone(){
return _phone;
}  
}
