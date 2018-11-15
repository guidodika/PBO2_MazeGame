/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegameguidodika;

import java.awt.Image;

/**
 *
 * @author My Computer
 */
public class Pixel {
    
    private int x;
    private int y;
    private Image image;
    private int jarak = 20;

    public Pixel(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
    
    public boolean posisiKiriObjek(Pixel Objek){
        if(((this.getX() - jarak) == Objek.getX()) && (this.getY() == Objek.getY())){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean posisiKananObjek(Pixel Objek){
        if(((this.getX() + jarak) == Objek.getX()) && (this.getY() == Objek.getY())){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean posisiAtasObjek(Pixel Objek){
        if(((this.getY() - jarak) == Objek.getY()) && (this.getX() == Objek.getX())){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean posisiBawahObjek(Pixel Objek){
        if(((this.getY() + jarak) == Objek.getY()) && (this.getX() == Objek.getX())){
            return true;
        } else {
            return false;
        }
    }
}
