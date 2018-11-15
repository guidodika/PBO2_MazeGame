/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo
 */
public class keterangan {
    public  static String terjemah(String input){
        String in[] = input.split(" ");
        if (in.length > 2) {
            return " kepanjangan ";
        }else{
            if (in.length == 2) {
                if (in[0].matches("[udrlz]")) {                                  
                if (in[0].equalsIgnoreCase("u")) {
                    return " naik";
                }else if (in[0].equalsIgnoreCase("u")) {
                        return "naik";
                    }else if (in[0].equalsIgnoreCase("d")) {
                        return "turun";
                    }else if (in[0].equalsIgnoreCase("r")) {
                        return "kanan";
                    }else if (in[0].equalsIgnoreCase("l")) {
                        return "kiri";
                    }else if (in[0].equalsIgnoreCase("z")) {
                        return "undo";
                    }else{
                        return "perintah salah";
                    }}else {
                        return "kata tidak di kenal";
                    }} else return " jumlah kata 1";
                
                }
            }
        }
  
