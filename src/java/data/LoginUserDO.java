/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Mauri
 */


public class LoginUserDO {
    private int _id;
    private String _senha;
    private String _username;

    public int getId() {
        return _id;
    } // getId

    public void setId(int id) {
        _id = id;
    } // setId

     
    public String getSenha() {
        return _senha;
    }

    public void setSenha(String senha) {
        _senha = senha;
    }

 
    public void setUsername(String username) {
        _username = username;
    }

    public String getUsername() {
        return _username;
    }
}
