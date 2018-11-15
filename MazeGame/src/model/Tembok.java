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
public class Tembok extends Sel{

    Tembok(int baris, int kolom) {
        super(baris ,kolom);
        
        URL loc  = this.getClass().getResource("tembok.txt");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
    
}
