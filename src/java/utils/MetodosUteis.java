/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Murilo
 */
public class MetodosUteis {
    
    
    public static boolean isEmpty(String s) {
     if (null == s)
       return true;
     if (s.length() == 0)
       return true;
     return false;
    }
    
    public static boolean isCurrency(String s) {
        String[] a = s.split("\\.");
        System.out.print("erro currency: "+a.length);
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
    
    
    
}


