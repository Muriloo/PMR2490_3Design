/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;

/**
 *
 * @author Murilo
 */
public class MetodosUteis {
    
    private static final int magicNumbers_jpg = 0xffd8ffe0;
    private static final int magicNumbers_png = 0x89504E47;
    
    public static boolean isEmpty(String s) {
     if (null == s)
       return true;
     if (s.length() == 0)
       return true;
     return false;
    }
    
    public static boolean isCurrency(String s) {
        String[] a = s.split("\\.");
        System.out.print("casas currency: "+a.length);
        if (a.length == 2){
            if(a[1].length() <= 2){
                return true;
            }
        }
        return false;
    }
    
    public static String dateToDate(String s) {//muda a data de YY-MM-DD hh-mm-ss pra DD/MM/YY
        String[] a = s.split("-");
        System.out.print("erro currency: "+a.length);
        String[] b = a[2].split(" ");
        String date = b[0] + "/" +a[1] + "/" +a[0];
        return date;
    }
    
    public static Boolean isFormat(File filename, String extension) throws Exception {
        
        int magicNumbers = magicNumbers_jpg;
        if (extension == "jpg"){
            magicNumbers = magicNumbers_jpg;
        } else if (extension == "png"){
            magicNumbers = magicNumbers_png;
        }
        System.out.print("checking file format:" + magicNumbers_jpg);
        
        DataInputStream ins = new DataInputStream(new BufferedInputStream(new FileInputStream(filename)));
        try {
            if (ins.readInt() == magicNumbers) {
                //System.out.print("true;");
                return true;
            } else {
                //System.out.print("false----");
                return false;
            }
        } finally {
            ins.close();
        }
    }
    
    
    
}


