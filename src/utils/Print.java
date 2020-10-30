/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import static java.lang.Integer.max;
import java.util.ArrayList;
import jktvr19_ostromogilskii_laptops.App;
/**
 *
 * @author pupil
 */
public class Print {
    
    //print menu with borders
    public static void printList(ArrayList list){
        
        //if list is empty
        if(list.isEmpty()){
            emptyMessage();
            return;
        }
        
        //get max length of printing strings
        int len = getLen(list);
        
        //print strings 
        printLine(len);
        for (int i=0;i<list.size();i++) {          
            String str = String.format("| %d. %s ", i+1, list.get(i).toString());
            System.out.printf("%"+-len+"s |\n", str);
            printLine(len);
        }
        
    }
    
    
    //print menu with borders
    public static void printList(String[] list){
        
        //if list is empty
        if(list.length == 0){
            emptyMessage();
            return;
        }
        
        //get max length of printing strings
        int len = getLen(list);
        
        //print strings 
        printLine(len);
        for (int i=0;i<list.length;i++) {
            String str = String.format("| %d. %s ", i, list[i]);
            System.out.printf(String.format("%"+-len+"s |\n",str));
        }
        printLine(len);
    }
    
    //if no data message
    public static void emptyMessage(){       
        printLine();
        System.out.println("|"+App.BLUE+"               НЕТ ДАННЫХ             "+App.RESET+"|");
        printLine();
    }
    
    
    
    //message with red bg
    public static void error(String str){
        System.out.print(App.RED_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET);
    }
    public static void error(String str, String after){
        System.out.print(App.RED_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET + " " + after);
    }
    public static void errorln(String str){
        System.out.println(App.RED_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET);
    }
    public static void errorln(String str, String after){
        System.out.println(App.RED_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET + " " + after);
    }
    
    //message with blue bg
    public static void alert(String str){
        System.out.print(App.BLUE_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET);
    }
    public static void alert(String str, String after){
        System.out.print(App.BLUE_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET + " " + after);
    }
    public static void alertln(String str){
        System.out.println(App.BLUE_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET);
    }
    public static void alertln(String str, String after){
        System.out.println(App.BLUE_BACKGROUND + App.WHITE + " " + str.toUpperCase() + " " + App.RESET + " " + after);
    }
    
    public static void printLine(int count){
        for(int i=0;i<count;i++){
           System.out.print("-"); 
        }System.out.println("");
    }
    public static void printLine(){
        for(int i=0;i<40;i++){
           System.out.print("-"); 
        }System.out.println("");
    }
    
    //get max length of printing strings
    public static int getLen(ArrayList list){
        int len = 0;
        String str;
        for (int i=0;i<list.size();i++) {
            str = String.format("| %d. %s |\n", i, list.get(i).toString());
            len = max(len, str.length());    
        }
        return len;
    }
    public static int getLen(String[] list){
        int len = 0;
        String str;
        for (int i=0;i<list.length;i++) {
            str = String.format("| %d. %s |\n", i, list[i]);
            len = max(len, str.length());    
        }
        return len;
    }
}