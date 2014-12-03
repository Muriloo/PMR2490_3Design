package utils;

import java.sql.*;

public class Transacao {

  // connection data
  static final String driver = "com.mysql.jdbc.Driver";
  static final String url = "jdbc:mysql://localhost/3design?";
  static final String uid = "root";
  static final String pwd = "Pmr2490";
  
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