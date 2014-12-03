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

import utils.MetodosUteis;
/**
 *
 * @author Murilo
 */
public class UploadProject {
    
    public boolean uploadProject(projectDO project, versionDO version, ArrayList<ImageDO> images) throws Exception{
        //validar regras de negocio
        System.out.print("validar regras, images size:"+images.size());
        System.out.print("validar regras, version file:"+version.getFilepath());
        System.out.print("validar regras, is currency:"+ utils.MetodosUteis.isCurrency(String.valueOf(project.getPrice())) );
        if ( !MetodosUteis.isFormat(new File("C:\\Users\\Murilo\\Documents\\NetBeansProjects\\3Design\\build\\web\\Files\\"+version.getFilepath()), "jpg") || 
                MetodosUteis.isEmpty(project.getName()) || MetodosUteis.isEmpty(project.getDetail())
                || MetodosUteis.isEmpty(project.getDescription()) || 
                !(project.getPrice() > 0 && project.getPrice() < 1000000 && utils.MetodosUteis.isCurrency(String.valueOf(project.getPrice())) ) || 
                images.size() == 0) {//TODO: check image format
            
              return false;
        }
        
        //generating thumbnails
        
        
               
         // efetuando a transacao
        Transacao tr = new Transacao();
        try {

          tr.begin();
          System.out.print("upload project");
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
    
}
