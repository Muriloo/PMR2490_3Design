/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectServlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="UploadServlet", urlPatterns={"/upload"})     // specify urlPattern for servlet
@MultipartConfig                                               // specifies servlet takes multipart/form-data
public class UploadServlet extends HttpServlet {
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.print("chegou aqui: ");
        try {
            // get access to file that is uploaded from client
            System.out.print("chegou no try: ");
                       
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String comments = request.getParameter("comments");
            Part file = request.getPart("file");
            InputStream file_is = file.getInputStream();
            //String images = request.getParameter("images");
            String price_str = request.getParameter("price");

            float price = 0;
            boolean result = false;
            
            System.out.print("comments:"+comments);
            try {
                if (!utils.MetodosUteis.isEmpty(price_str)){
                    price = Float.valueOf(price_str).floatValue();                    
                }
                project.projectDO project = new project.projectDO(name, description, comments, price, "");
                project.versionDO version = new project.versionDO();
                if(file.getSize() > 0){
                    version.setFile(file_is);
                }
                
                transaction.UploadProject upProject = new transaction.UploadProject();
                try {
                    result = upProject.uploadProject(project, version);
                } catch (Exception e){
                    System.out.print("ERROR!");
                }
            } catch (NumberFormatException e){
               System.out.print("ERROR!");
            }
            
//            FileOutputStream imageOutFile = new FileOutputStream("C:\\Users\\Murilo\\Pictures\\teste.jpg");
//            int ch = is.read();
//            while (ch != -1) {
//                 imageOutFile.write(ch);
//                 ch = is.read();
//            }
//			
//            imageOutFile.close();
//                   
           out.println("<h3>File uploaded successfully!</h3>");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        catch(Exception ex) {
           out.println("Exception -->" + ex.getMessage());
        }
        finally { 
            out.close();
        }
    } // end of doPost()
 } // end of UploadServlet
