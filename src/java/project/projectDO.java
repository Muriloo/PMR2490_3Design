/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.util.ArrayList;
import java.io.InputStream;

/**
 *
 * @author Arthur
 */

public class projectDO {
    
    private int _id;
    private String _name;
    private String _description;
    private String _detail;
    private int _status_id;
    private float _price;
    
    private int _customerId;

<<<<<<< HEAD
    public projectDO(String name, String description, String detail, float price){
=======
    public projectDO(){}
    
    public projectDO(String name, String description, String detail, float price, String images){
>>>>>>> RamoRodrigoY
        this.setName(name);
        this.setDescription(description);
        this.setDetail(detail);
        this.setPrice(price);
    }
    
    public projectDO(){        
    }
    
    
    public int getCustomerId() {
        return _customerId;
    }

    public void setCustomerId(int _customerId) {
        this._customerId = _customerId;
    }
       
  public int getId() {
     return _id;
  } // getId

  public void setId(int id) {
    _id = id;
  } // setId

  public String getName() {
     return _name;
  } // getName

  public void setName(String name) {
    _name = name;
  } // setName

public String getDescription() {
     return _description;
  } // getDescription

  public void setDescription(String descript) {
    _description = descript;
  } // setDescription

public String getDetail() {
     return _detail;
  } // getDetail

  public void setDetail(String detail) {
    _detail = detail;
  } // setDetail

  public int getStatusId() {
     return _status_id;
  } // getStatusId

  public void setStatusId(int status_id) {
    _status_id = status_id;
  } // setStatusId
  
public float getPrice() {
     return _price;
  } // getPrice

  public void setPrice(float price) {
    _price = price;
  } // setPrice
} // projectDO