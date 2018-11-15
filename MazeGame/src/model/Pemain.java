/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Lenovo
 */
class Pemain extends Sel{

   public Pemain(int baris, int kolom) {
        super(baris,kolom);
        
        URL loc = this.getClass().getResource("pemain.txt");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
          
    }
   public void bergerak(){
       int gerB = this.getBaris() + baris;
       int gerK = this.getKolom() + kolom;
       this.setBaris(gerB);
       this.setKolom(gerK);
   }
    
}
