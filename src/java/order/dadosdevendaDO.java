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
    private float _Sold_total;
    private int _Sold_quantity;
    private String _project_name; 
    private int _project_status_id;
    private int _id;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public float getSold_total() {
        return _Sold_total;
    }

    public void setSold_total(float _Sold_total) {
        this._Sold_total = _Sold_total;
    }

    public int getSold_quantity() {
        return _Sold_quantity;
    }

    public void setSold_quantity(int _Sold_quantity) {
        this._Sold_quantity = _Sold_quantity;
    }

    public String getProject_name() {
        return _project_name;
    }

    public void setProject_name(String _project_name) {
        this._project_name = _project_name;
    }

    public int getProject_status_id() {
        return _project_status_id;
    }

    public void setProject_status_id(int _project_status_id) {
        this._project_status_id = _project_status_id;
    }
       
    }
            
    

