/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.sql.*;
/**
 *
 * @author Mauri
 */
public class Transacao {
  static final String driver = "com.mysql.jdbc.Driver";

  static final String url = "jdbc:mysql://localhost/3design?";
  static final String uid = "root";
  static final String pwd = "1234";
  
  private Connection _conexao = null;
  private boolean _readOnly = false;

  public void begin() throws Exception{
      Class.forName(driver).newInstance();
      _conexao = DriverManager.getConnection(url,uid,pwd);
      _conexao.setAutoCommit(false);
	  _readOnly = false;
  } // begin

  public void beginReadOnly() throws Exception{
      Class.forName(driver).newInstance();
      _conexao = DriverManager.getConnection(url,uid,pwd);
	  _readOnly = true;
  } // begin

  public void commit() throws Exception {
      if ( !_readOnly) {
         _conexao.commit();
	  }
	  _conexao.close();
  } // commit

  public void rollback() throws Exception {
      if ( !_readOnly) {
         _conexao.rollback();
	  }
	  _conexao.close();
  } // rollback

  public Connection obterConexao() {
      return _conexao;
  } // obterConexao


} // Transacao

