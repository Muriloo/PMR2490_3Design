/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comment;

import data.*;

/**
 *
Table: comment
Columns:
id int(11) AI PK 
comment_project_id int(11) 
comment_customer_id int(11) 
comment varchar(500) 
created_at datetime 
updated_at datetime 
deleted tinyint(1) 
deleted_at datetime 
modified_by int(18)
 */
public class CommentDO {

    private int _id;
    private int _comment_project_id;
    private int _comment_customer_id;
    private String _comment;
    private String _created_at;

    public int getId() {
        return _id;
    } // getId

    public void setId(int id) {
        _id = id;
    } // setId

    public int getProjectId() {
        return _comment_project_id;
    } // obterNome

    public void setProjectId(int projectId) {
        _comment_project_id = projectId;
    } // setNome

    public int getCustomerId() {
        return _comment_customer_id;
    } // getTelefone

    public void setCustomerId(int customerId) {
        _comment_customer_id = customerId;
    } // setTelefone
    
    public String getComment() {
        return _comment;
    }
    
    public void setComment(String comment) {
        _comment = comment;
    }

    public String getCreatedAt() {
        return _created_at;
    }
    
    public void setCreatedAt(String createdAt) {
        _created_at = createdAt;
    }

}
