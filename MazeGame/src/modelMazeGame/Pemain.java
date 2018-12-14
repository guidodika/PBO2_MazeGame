/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelMazeGame;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author My Computer
 */
public class Pemain extends Pixel {
    public Pemain (int x, int y){
        super (x,y);
        
        URL location = this.getClass().getResource("pemain.jpg");
        ImageIcon g = new ImageIcon(location);
        Image image = g.getImage();
        this.setImage(image);
    }
    
    public void Gerak(int x, int y){
        int langkahX = this.getX() + x;
        int langkahY = this.getY() + y;
        this.setX(langkahX);
        this.setY(langkahY);
    }
}
