/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectServlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.RequestDispatcher;

import project.ImageDO;

/**
 * Servlet implementation class UploadServlet
 */
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DATA_DIRECTORY = "Files";
    private static final int MAX_MEMORY_SIZE = 1024 * 1024 *20;
    private static final int MAX_REQUEST_SIZE = 1024 * 1024*20;

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
                    
                    String fullFileName =  field_name+"_" +System.currentTimeMillis()+
                            "_"+fileName;
                    
                    String filePath = uploadFolder + File.separator + fullFileName;
                    File uploadedFile = new File(filePath);
                    
                    System.out.print("filePath loop: "+filePath);
                    if( field_name.equals("projectFile") ){
                        if (fileName == "" || fileName.isEmpty()){
                            //RequestDispatcher rd = getServletContext().getRequestDispatcher("/PaginaDoDesenvolvedor/uploadprojeto.jsp");
                            PrintWriter out3 = response.getWriter();
                            
                            //rd.include(request, response);
                            
                            response.sendRedirect("./PaginaDoDesenvolvedor/uploadprojeto.jsp?error=nofile");
                            //out3.println("<font color=red>Favor escolher um arquivo.</font>");
                            return;
                        }
                        map.put(field_name, fullFileName);
                        System.out.print("projectFile: "+fullFileName);
                        // saves the file to upload directory
                        item.write(uploadedFile);
                    }
                    else if (field_name.equals("image") && (fileName != "" && !fileName.isEmpty())){
                        ImageDO image = new ImageDO();
                        image.setImagelink(fullFileName);
                        imagesDO.add(image);
                        // saves the file to upload directory
                        item.write(uploadedFile);
                    }
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
                    System.out.print("ERROR! Upload");
                    response.sendRedirect("./PaginaDoDesenvolvedor/uploadprojeto.jsp?error=erroruploading");
                    //RequestDispatcher rd = getServletContext().getRequestDispatcher("/done.jsp");
                    //PrintWriter out = response.getWriter();
                    //out.println("<font color=red>Erro ao subir pr0ojeto.</font>");
                    //rd.include(request, response);
                    
                    return;
                }
            } catch (NumberFormatException e){
               System.out.print("ERROR! Number Format");
            }
            
            // displays done.jsp page after upload finished
             
             PrintWriter out2 = response.getWriter();
           RequestDispatcher rd;
            if (result) {
                response.sendRedirect("./done.jsp");
                out2.println("<h3>Seu arquivo projeto foi enviado com sucesso para aprovação dos moderadores!</h3>");
            } else {
                //rd = getServletContext().getRequestDispatcher("/PaginaDoDesenvolvedor/uploadprojeto.jsp");
                //out2.println("<font color=red>Favor preencher os campos corretamente.</font>");
                response.sendRedirect("./PaginaDoDesenvolvedor/uploadprojeto.jsp?error=wrongfields");
            }
            //rd.include(request, response);

        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

}