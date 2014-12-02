/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import data.*;

/**
 *
 * @author Mauri
 */
public class cartDO {

    private int _id;
    private int _customer_id;
    private int _project_id;
    private int _quantity;

    public int getId() {
        return _id;
    } // getId

    public void setId(int id) {
        _id = id;
    } // setId

    public int getCustomerId() {
        return _customer_id;
    } // obterNome

    public void setCustomerId(int customerId) {
        _customer_id = customerId;
    } // setNome

    public int getProjectId() {
        return _project_id;
    } // getTelefone

    public void setProjectId(int projectId) {
        _project_id = projectId;
    } // setTelefone
    
    public int getQuantity() {
        return _quantity;
    }
    
    public void setQuantity(int quantity) {
        _quantity = quantity;
    }


}
