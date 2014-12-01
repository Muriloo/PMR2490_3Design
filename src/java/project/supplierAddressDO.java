/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Arthur
 */
public class supplierAddressDO {
    
    private int _id;
    private int _supplier;
    private String _country;
    private String _state;
    private String _street;
    private String _complement;
    private String _postalcode;

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getSupplier() {
        return _supplier;
    }

    public void setSupplier(int _supplier) {
        this._supplier = _supplier;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String _country) {
        this._country = _country;
    }

    public String getState() {
        return _state;
    }

    public void setState(String _state) {
        this._state = _state;
    }

    public String getStreet() {
        return _street;
    }

    public void setStreet(String _street) {
        this._street = _street;
    }

    public String getComplement() {
        return _complement;
    }

    public void setComplement(String _complement) {
        this._complement = _complement;
    }

    public String getPostalcode() {
        return _postalcode;
    }

    public void setPostalcode(String _postalcode) {
        this._postalcode = _postalcode;
    }
}
