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
public class orderitemDO {
    
     private int _id;
    private int _order_id;
    private int _project_id;
    private int _order_item_quantity;
    private float _item_unit_price;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getOrder_id() {
        return _order_id;
    }

    public void setOrder_id(int _order_id) {
        this._order_id = _order_id;
    }

    public int getProject_id() {
        return _project_id;
    }

    public void setProject_id(int _project_id) {
        this._project_id = _project_id;
    }

    public int getOrder_item_quantity() {
        return _order_item_quantity;
    }

    public void setOrder_item_quantity(int _order_item_quantity) {
        this._order_item_quantity = _order_item_quantity;
    }

    public float getItem_unit_price() {
        return _item_unit_price;
    }

    public void setItem_unit_price(float _item_unit_price) {
        this._item_unit_price = _item_unit_price;
    }
    
}
