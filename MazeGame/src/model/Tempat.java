/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author user only
 */
public class Tempat extends JPanel {
    private int tinggi; // tinggi tempat Game
    private int lebar;  // lebar tempat Game
    private ArrayList<Sel> daftarSel; // daftar sel
    private ArrayList<Tembok> daftartambok;
    private ArrayList<pintu> daftarPintu;
//    private ArrayList Map;
    private ArrayList map = new ArrayList();
    private ArrayList allperintah = new ArrayList();
    private ArrayList pemain = new ArrayList();
    private File alamattempat;
    private Pemain org;

    private int jarak = 20;
    private String isi; // isi file konfigurasi
    
    public static int batasKanan;
    public static int batasBawah;
    
    public Tempat() {
        daftarSel = new ArrayList<Sel>();
    }
    public Tempat(File file){
        bacaKonfigurasi( file);
    }
    
    
    /**
     * Fungsi pembaca file konfigurasi.
     * Hasil pembacaan file akan disimpan di atribut 'isi' dan juga di atribut daftarSel
     * @param file 
     */
    public void bacaKonfigurasi(File file) {
//        char bacakarakter = 0;
//        boolean hasil = false;
//        Tempat point = new Tempat();
        
        try { 
        FileInputStream fis = null;
        this.isi = " ";
        int data;
        int baris = 0; int  kolom = 0;
            if (file != null) {
                 alamattempat = file;
                 baris = 0;
                 kolom = 0;
                Tembok wall;
                pintu Gate;                                
                          
       fis = new FileInputStream(file);
        while((data = fis.read()) != -1){  
          
            char item =  (char) data;
            
            if (item != '\n') {
                kolom += jarak;
                
                if (this.lebar < baris) {
                    this.lebar = baris;               
                }  baris = 0;         
            } else if (item == '#') {
                wall = new Tembok(baris,kolom);
                daftartambok.add(wall);
                baris += jarak;
            }else if (item == 'o') {
                Gate = new pintu(baris ,kolom);
                daftarPintu.add(Gate);
            }else if (item == '@') {
                org = new Pemain(baris, kolom);
                baris += jarak;
            }else if (item == '.') {
                baris += jarak;
            } tinggi= kolom;

            }     
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void buatKomponen (Graphics g){
       super.paintComponent(g);
       // t4 gambar
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());
        map.addAll(daftartambok);
        map.addAll(daftarPintu);
        map.add(org);
        for (int i = 0; i < map.size() ; i++) {
            if (map.get(i) != null) {
               Sel item = (Sel) map.get(i);
//      \\\\///????         g.drawImage(item.geti, i, i, this)
            }
        }        
    }
    public void PerintahGerak(String input){
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "jumlah kata kelebihan");
        }else if (in.length == 2) {
            if (in[0].matches("[udrlz]")) {
                allperintah.add(input);
                if (in[0].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cektabrak(org ,"u")) {
                            
                        }
                    }
                }
                
            }
        }
    }
    private boolean cektabrak(Sel pemain, String input){
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < daftartambok.size(); i++) {
                Tembok wall = (Tembok) daftartambok.get(i);
                if (pemain.isBatasKiri(wall)) {
                    bantu = true;
                    break;
                }
            }
        }else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < daftartambok.size(); i++) {
                Tembok wall = (Tembok) daftartambok.get(i);
                if (pemain.isBatasKanan(wall)) {
                    bantu = true;
                    break;
                }
            }
        }else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < daftartambok.size(); i++) {
                Tembok wall = (Tembok) daftartambok.get(i);
                if (pemain.isBatasAtas(wall)) {
                    bantu = true;
                    break;
                }
            }
        }else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < daftartambok.size(); i++) {
                Tembok wall = (Tembok) daftartambok.get(i);
                bantu = true;
                break;
            }
        }
        return bantu;
    }
    public  void Completed(){
        int jlnpem = pemain.size();
        int goal = 0;
        for (int i = 0; i < pemain.size(); i++) {
            Pemain pem = (Pemain) pemain.get(i);
            for (int j = 0; j < daftarPintu.size(); j++) {
                pintu door = (pintu) daftarPintu.get(j);
                if (pem.getBaris() == door.getBaris() && pem.getKolom() == door.getKolom()) {
                    goal += 1;
                }
            }
        }if (goal == jlnpem) {
            JOptionPane.showMessageDialog(null, "selesai");
        }
    }
    public String getPerintahTeks(){
        String bantu = " ";
        for (int i = 0; i < allperintah.size(); i++) {
            bantu += allperintah.get(i) + " ";
        }
        return bantu;
    }
    
    
    /**
     * Fungsi penambah daftar sel.
     * @param sel 
     */
    public void tambahSel(Sel sel){
        daftarSel.add(sel);
    }

    /**
     * Fungsi hapus sel.
     * Sel yang paling akhir diremove dari daftar sel.
     */
    public void hapusSel(){
        if(!daftarSel.isEmpty()){
            daftarSel.remove(daftarSel.size()-1);
        }
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
     * @return the daftarSel
     */
    public ArrayList<Sel> getDaftarSel() {
        return daftarSel;
    }

    /**
     * @param daftarSel the daftarSel to set
     */
    public void setDaftarSel(ArrayList<Sel> daftarSel) {
        this.daftarSel = daftarSel;
    }

    /**
     * @return the isi
     */
    public String getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(String isi) {
        this.isi = isi;
    }
}
