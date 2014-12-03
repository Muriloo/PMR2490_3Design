/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

/**
 *
 * @author Eduardo Seiti
 */
public class dadosdevendaDO {
    private float _SoldTotal;
    private int _SoldQuantity;
    private String _project_name; 
    private int _project_status_id;

    public int getProject_status_id() {
        return _project_status_id;
    }

    public void setProject_status_id(int _project_status_id) {
        this._project_status_id = _project_status_id;
    }

    public float getSoldTotal() {
        return _SoldTotal;
    }

    public void setSoldTotal(float _SoldTotal) {
        this._SoldTotal = _SoldTotal;
    }

    public int getSoldQuantity() {
        return _SoldQuantity;
    }

    public void setSoldQuantity(int _SoldQuantity) {
        this._SoldQuantity = _SoldQuantity;
    }

    public String getProject_name() {
        return _project_name;
    }

    public void setProject_name(String project_name) {
        this._project_name = _project_name;
    }
            
    
}
