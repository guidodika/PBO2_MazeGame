/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Image;

/**
 *
 * @author user only
 */
public class Sel {

    int baris=0;
    int kolom=0;
    private int lebar=25;
    private int tinggi=25;
    private Image image;
    private int jarak = 20;

    private char nilai;

    private Color warna;

    public Sel() {
    }
    
    public Image GetImage(){
        return image;
    }
    
    public void setImage(Image image){
        this.image = image;
    }

    public Sel(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
        
    }

    public Sel(int baris, int kolom, char nilai, Color warna) {
        this.baris = baris;
        this.kolom = kolom;
        this.nilai = nilai;
        this.warna = warna;
    }

    public Sel(int baris, int kolom, int lebar, int tinggi, char nilai, Color warna) {
        this.baris = baris;
        this.kolom = kolom;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.nilai = nilai;
        this.warna = warna;
    }

    /**
     * Fungsi mengecek sel ada di batas kiri
     *
     * @return
     */
    public boolean isBatasKiri(Sel objek) {
        if (((this.getBaris()-jarak) == objek.getBaris())&& (this.getKolom() == objek.getKolom())) {
            return true;
        }else {
            return false;
        }

    }

    /**
     * Fungsi ceking sel ada di batas kanan
     *
     * @return
     */
    public boolean isBatasKanan(Sel Objek) {
        if (((this.getBaris() + jarak == Objek.getBaris()) && (this.getKolom()) == Objek.getKolom())) {
            return true;
            
        }else {
            return false;
        }
    }
    /**
     * Fungsi untuk mengecek sel ada di batas atas
     */
    public boolean isBatasAtas(Sel Objek) {
        if (((this.getKolom() - jarak) == Objek.getKolom()) && (this.getBaris() == Objek.getBaris())) {
            return true;
        }else {
            return false;
        }
    }
    /**
     * Fungsi untuk mengecek sel ada di batas bawah
     */
    public boolean isBatasBawah(Sel Objek) {
        if (((this.getKolom() + jarak) == Objek.getKolom()) && (this.getBaris()) == Objek.getBaris()) {
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * @return the baris
     */
    public int getBaris() {
        return baris;
    }

    /**
     * @param baris the baris to set
     */
    public void setBaris(int baris) {
        this.baris = baris;
    }

    /**
     * @return the kolom
     */
    public int getKolom() {
        return kolom;
    }

    /**
     * @param kolom the kolom to set
     */
    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    /**
     * @return the nilai
     */
    public char getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    /**
     * @return the warna
     */
    public Color getWarna() {
        return warna;
    }

    /**
     * @param warna the warna to set
     */
    public void setWarna(Color warna) {
        this.warna = warna;
    }

    /**
     * @return the lebar
     */
    public int getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

}
