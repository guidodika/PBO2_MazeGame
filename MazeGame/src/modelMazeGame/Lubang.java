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
public class Lubang extends Pixel{
    public Lubang (int x, int y){
        super(x,y);
        
        URL location = this.getClass().getResource("pintu.png");
        ImageIcon img = new ImageIcon(location);
        Image image = img.getImage();
        this.setImage(image);
        
    }
}
