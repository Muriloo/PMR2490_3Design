/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Murilo
 */
public class ImageDO {
    
    private String _imagelink;

    public String getImagelink() {
        return _imagelink;
    }

    public void setImagelink(String _imagelink) {
        this._imagelink = _imagelink;
    }

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public int getVersion_id() {
        return _version_id;
    }

    public void setVersion_id(int _version_id) {
        this._version_id = _version_id;
    }
    private int _id;
    private int _version_id;
}
