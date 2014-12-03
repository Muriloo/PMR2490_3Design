/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectServlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

import project.ImageDO;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DATA_DIRECTORY = "Files";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 *100;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024*100;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            return;
        }

        // Create a factory for disk-based file items
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Sets the size threshold beyond which files are written directly to
        // disk.
        factory.setSizeThreshold(MAX_MEMORY_SIZE);

        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for
        // java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // constructs the folder where uploaded file will be stored
        String uploadFolder = getServletContext().getRealPath("")
                + File.separator + DATA_DIRECTORY;

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
        

        try {
            Map<String, String> map = new HashMap<String, String>();
            ArrayList<String> imgs_str = new ArrayList<String>();
            boolean result = false;
            float price = 0;
            
            ArrayList<ImageDO> imagesDO = new ArrayList<ImageDO>();
            // Parse the request
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            String field_name;
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                field_name = item.getFieldName();
                if (!item.isFormField() ) {
                    String fileName = new File(item.getName()).getName();
                    //if (field_name.equals("image")){
                    String fullFileName =  field_name+"_" +System.currentTimeMillis()+
                            "_"+fileName;
                    
                    String filePath = uploadFolder + File.separator + fullFileName;
                    File uploadedFile = new File(filePath);
                    
                    System.out.print("filePath loop: "+filePath);
                    if( field_name.equals("projectFile") ){
                        map.put(field_name, fullFileName);
                        System.out.print("projectFile: "+fullFileName);
                    }
                    else if (field_name.equals("image")){
                        ImageDO image = new ImageDO();
                        image.setImagelink(fullFileName);
                        imagesDO.add(image);
                    }
                    //--System.out.print("Path: "+filePath);
                    //--System.out.print("fullFileName: "+fullFileName);
                   
                    // saves the file to upload directory
                    item.write(uploadedFile);
                }
                else{
                    System.out.print("var "+item.getFieldName()+": "+item.getString());
                    map.put(item.getFieldName(), item.getString());
                }
            }
            
            try {
                String price_str = map.get("price");
                if (!utils.MetodosUteis.isEmpty(price_str)){
                    price = Float.valueOf(price_str).floatValue();                    
                }
                project.projectDO project = new project.projectDO(map.get("name"),  map.get("description"),  
                        map.get("comments"), price, 0);
                project.versionDO version = new project.versionDO();
                version.setFilepath(map.get("projectFile"));
                System.out.print("filename:"+map.get("projectFile"));
                transaction.UploadProject upProject = new transaction.UploadProject();
                try {
                    result = upProject.uploadProject(project, version, imagesDO);
                } catch (Exception e){
                    System.out.print("ERROR!");
                }
            } catch (NumberFormatException e){
               System.out.print("ERROR!");
            }
            
            // displays done.jsp page after upload finished
            getServletContext().getRequestDispatcher("/done.jsp").forward(
                    request, response);

        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

}