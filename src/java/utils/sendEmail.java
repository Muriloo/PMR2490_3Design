/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import project.versionDO;
import user.userDO;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

/**
 *
 * @author Arthur
 */
public class sendEmail {
    // File Name sendEmail.java

  /**
       Outgoing Mail (SMTP) Server
       requires TLS or SSL: smtp.gmail.com (use authentication)
       Use Authentication: Yes
       Port for SSL: 465
     */
    
    public boolean pendingProjectEmail(boolean approval, String emailAddress, versionDO version, String comment) {
        
        final String fromEmail = "3designpoli@gmail.com"; //requires valid gmail id
        final String password = "Pmr2490SI"; // correct password for gmail id
        final String toEmail = "arthurgola@hotmail.com"; // can be any email id 
        String message;
        String versionName = version.getName();
        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port
         
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        String subject = "3Design: Status de versão pendente alterado";
        if (approval) {
            message = "Parabéns! A versão " + versionName + " de seu projeto foi aprovada por um moderador!"
                    + "\nComentário do moderador: " + comment;
        }
        else {
            message = "Infelizmente a versão " + versionName + " de seu projeto foi rejeitada por um moderador.\n Retifique seu "
                + "projeto e tente novamente.\nComentário do moderador: " + comment;
        }
                Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
            return emailUtil.sendEmail(session, toEmail,subject, message);
 
 
        
        
        
        
    }//pendingProjectEmail
    
    public static void main(String[] args) {
        final String fromEmail = "3designpoli@gmail.com"; //requires valid gmail id
        final String password = "Pmr2490SI"; // correct password for gmail id
        final String toEmail = "arthurgola@hotmail.com"; // can be any email id 
         
        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port
         
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
         
        Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
            emailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", "SSLEmail Testing Body");
 
 
         
   }//main
    
    public boolean deleteUserEmail(String emailAddress, String name) {
        
        final String fromEmail = "3designpoli@gmail.com"; //requires valid gmail id
        final String password = "Pmr2490SI"; // correct password for gmail id
        final String toEmail = emailAddress; // can be any email id 
        String message;
        System.out.println("SSLEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port
         
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        String subject = "3Design: Conta Deletada";
            message = name + ", sua conta foi encerrada";
        
                Session session = Session.getDefaultInstance(props, auth);
        System.out.println("Session created");
            return emailUtil.sendEmail(session, toEmail,subject, message);
 
 
        
        
        
        
    }//deleteuserEmail
}//sendEmail

