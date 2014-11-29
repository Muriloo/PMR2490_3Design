/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
import java.io.*;

/**
 *
 * @author Arthur
 */
public class versionDO {
    
    private int _id;
    private String _name;
    private String _project_name;
    private int _visibility;
    private int _status_id;
    private int _project_id;
    private String _file;

    
    
    public String getFile() {
        return _file;
    }

    public void setFile(String _file) {
        this._file = _file;
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
  
  public String getProjectName() {
     return _project_name;
  } // getProjectName

  public void setProjectName(String name) {
    _project_name = name;
  } // setProjectName

public int getVisibility() {
     return _visibility;
  } // getVisibility

  public void setVisibility(int visib) {
    _visibility = visib;
  } // setVisibility

public int getProjectId() {
     return _project_id;
  } // getProjectId

  public void setProjectId(int project_id) {
    _project_id = project_id;
  } // setProjectId

  public int getStatusId() {
     return _status_id;
  } // getStatusId

  public void setStatusId(int status_id) {
    _status_id = status_id;
  } // setStatusId
  

    
}
/* 
_id
_name
_visibility
_status
_file
_project
*/