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
public class ThumbnailDO {
    
    private int _id;
    private String _thumbail_link;
    private int _thumbnail_image_id;
    private String _updated_at;
    

    public int getId() {
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }

    public String getThumbail_link() {
        return _thumbail_link;
    }

    public void setThumbail_link(String _thumbail_link) {
        this._thumbail_link = _thumbail_link;
    }

    public int getThumbnail_image_id() {
        return _thumbnail_image_id;
    }

    public void setThumbnail_image_id(int _thumbnail_image_id) {
        this._thumbnail_image_id = _thumbnail_image_id;
    }

    public String getUpdated_at() {
        return _updated_at;
    }

    public void setUpdated_at(String _updated_at) {
        this._updated_at = _updated_at;
    }
    
    
}
