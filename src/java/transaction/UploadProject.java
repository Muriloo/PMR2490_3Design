/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transaction;

import utils.*;
import project.*;
import java.util.*;
import java.io.InputStream;
import java.io.File;
/**
 *
 * @author Murilo
 */
public class UploadProject {
    
    public boolean uploadProject(projectDO project, versionDO version, ArrayList<ImageDO> images) throws Exception{
        //validar regras de negocio
        System.out.print("validar regras, name:"+project.getName());
        System.out.print("validar regras, is currency:"+ utils.MetodosUteis.isCurrency(String.valueOf(project.getPrice())) );
        if ( MetodosUteis.isEmpty(project.getName()) || MetodosUteis.isEmpty(project.getDetail())
                || MetodosUteis.isEmpty(project.getDescription()) || 
                !(project.getPrice() > 0 && project.getPrice() < 1000000 && 
                    utils.MetodosUteis.isCurrency(String.valueOf(project.getPrice())) ) || 
                !checkFileFormat(version.getFilepath(), "3D_format") ) {//TODO: check image format
              return false;
        }
        
         // efetuando a transacao
        Transacao tr = new Transacao();
        try {

          tr.begin();
            projectData pdata = new projectData();
            pdata.uploadProject(project, version, images, tr);
          tr.commit();
          return true;

        } catch(Exception e) {
            tr.rollback();
            System.out.println("erro ao gravar projeto " + project.getName());
            e.printStackTrace();
        }
        return false;
        
    }
    //TODO : check file format
    private boolean checkFileFormat(String is, String type){
        
//        File f = new File(filepath);
//        String mimetype= new MimetypesFileTypeMap().getContentType(f);
//        String type = mimetype.split("/")[0];
//        if(type.equals("image"))
//            System.out.println("It's an image");
//        else 
//            System.out.println("It's NOT an image");
        return true;
    }
}
