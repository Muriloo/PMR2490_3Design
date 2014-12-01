/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.Vector;
/**
 *
 * @author Arthur
 */
public class supplierDO {
    
    private int _id;
    private String _name;
    private double _evaluation; //decimal (2,1)
    private int _capacity_id;
    private String _comment;
    private String _description;
    private Vector _bank_info;
    private Vector _contact_info;
    private Vector _address;
    private String[] _materials;
    
    public String[] getMaterials(){
        return _materials;
    }
    
    public void setMaterials(String[] materials){
        _materials=materials;
    }
    
    public void setMaterials(int i, String material){
        _materials[i]=material;
    }

    public Vector getAddress() {
        return _address;
    }

    public void setAddress(Vector _address) {
        this._address = _address;
    }
        
    
    public int getId() {
     return _id;
  } // getId

  public void setId(int id) {
    _id = id;
  } // setId
  
  public int getCapacityId() {
     return _capacity_id;
  } // getCapacityId

  public void setCapacityId(int capacity_id) {
    _capacity_id = capacity_id;
  } // setCapacityId
  
  public String getName() {
     return _name;
  } // getName

  public void setName(String name) {
    _name = name;
  } // setName
  
  public double getEval() {
     return _evaluation;
  } // getEval

  public void setEval(double eval) {
    _evaluation = eval;
  } // setEval
  
   public String getComment() {
     return _comment;
  } // getComment

  public void setComment(String comment) {
    _comment = comment;
  } // setComment
  
   public String getDescription() {
     return _description;
  } // getDescription

  public void setDescription(String description) {
    _description = description;
  } // setDescription
  
  public void setBankInfo(int i, BankInfoDO bank_info){
      _bank_info.add(i, bank_info);
  }  
  
  public Vector getBankInfo(){
      return _bank_info;
  }  
  
  public void setContactInfo(int i, contactInfoDO contact){
      _contact_info.add(i, contact);
  }  
  
  public Vector getContactInfo(){
      return _contact_info;
  }  
  
}
