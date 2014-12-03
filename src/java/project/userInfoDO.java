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
 * @author Marcel
 */

public class userInfoDO {
    
    private int _id;
    private String _username;
    private String _country;
    private String _email;
    
    public userInfoDO(){        
    }
    

  public int getId() {
     return _id;
  } // getId

  public void setId(int id) {
    _id = id;
  } // setId

  public String getUsername() {
     return _username;
  } // getName

  public void setUsername(String username) {
    _username = username;
  } // setName

  public String getCountry() {
     return _country;
  } // getStatusId

  public void setCountry(String country) {
    _country = country;
  } // setStatusId
  
  
  public String getEmail() {
     return _email;
  } // getStatusId

  public void setEmail(String email) {
    _email = email;
  } // setStatusId
}