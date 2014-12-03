/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Arthur
 */
public class userDO {
    private int _id;
    private String _name;
    private String _lastname;
    private String _username;

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getLastname() {
        return _lastname;
    }

    public void setLastname(String _lastname) {
        this._lastname = _lastname;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String _country) {
        this._country = _country;
    }
    private String _country;
    private String _email;

    public userDO(){}
    

    
    

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
  
    public String getEmail() {
     return _email;
  } // getEmail

  public void setEmail(String email) {
    _email = email;
  } // setEmail
}