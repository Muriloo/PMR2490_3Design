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
public class ContatoDO {

    private int _id;
    private String _nome;
    private String _sobrenome;
    private String _email;
    private String _senha;
    private String _pais;
    private String _username;
    private int _userpermissionid;

    public int getUserpermissionid() {
        return _userpermissionid;
    }

    public void setUserpermissionid(int _userpermissionid) {
        this._userpermissionid = _userpermissionid;
    }

    public int getId() {
        return _id;
    } // getId

    public void setId(int id) {
        _id = id;
    } // setId

    public String getNome() {
        return _nome;
    } // obterNome

    public void setNome(String nome) {
        _nome = nome;
    } // setNome

    public String getSobrenome() {
        return _sobrenome;
    } // getTelefone

    public void setSobrenome(String sobrenome) {
        _sobrenome = sobrenome;
    } // setTelefone
    
    public String getEmail() {
        return _email;
    }
    
    public void setEmail(String email) {
        _email = email;
    }

    public String getSenha() {
        return _senha;
    }

    public void setSenha(String senha) {
        _senha = senha;
    }

    public void setPais(String pais) {
        _pais = pais;
    }

     public String getPais() {
        return _pais;
    }

    public void setUsername(String username) {
        _username = username;
    }

    public String getUsername() {
        return _username;
    }

}
