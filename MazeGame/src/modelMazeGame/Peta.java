/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelMazeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author My Computer
 */
public class Peta extends JPanel {

    private File AlamatPeta;
    private ArrayList perintah = new ArrayList();
    private ArrayList tembok = new ArrayList();
    private ArrayList lubang = new ArrayList();
    private ArrayList map = new ArrayList();
    private Pemain player;
    private int lebar = 0;
    private int tinggi = 0;
    private int jarak = 20;

    public Peta(File file) {
        setPeta(file);
    }

    public void setPeta(File file) {

        try {
            if (file != null) {
                FileInputStream input = new FileInputStream(file);
                AlamatPeta = file;
                int x = 0;
                int y = 0;
                Tembok wall;
                Lubang hole;
                int data;
                while ((data = input.read()) != -1) {
                    char item = (char) data;
                    if (item == '\n') {
                        y += jarak;
                        if (this.getLebar() < x) {
                            this.lebar = x;
                        }
                        x = 0;
                    } else if (item == '#') {
                        wall = new Tembok(x, y);
                        tembok.add(wall);
                        x += jarak;
                    } else if (item == 'o') {
                        hole = new Lubang(x, y);
                        lubang.add(hole);
                        x += jarak;
                    } else if (item == '@') {
                        player = new Pemain(x, y);
                    } else if (item == '.') {
                        x += jarak;
                    }
                    tinggi = y;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Peta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void paintComponent(Graphics gambar) {
        super.paintComponent(gambar);
        gambar.setColor(new Color(255, 255, 255));
        gambar.fillRect(0, 0, this.getLebar(), this.getTinggi());
        map.addAll(tembok);
        map.addAll(lubang);
        map.add(player);
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i) != null) {
                Pixel item = (Pixel) map.get(i);
                gambar.drawImage(item.getImage(), item.getX(), item.getY(), this);
            }

        }

    }

    /**
     * @return the lebar
     */
    public int getLebar() {
        return lebar;
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    public void PerintahGerak(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "Jumlah kata lebih dari 2");
        } else if (in.length == 2) {
            if (in[0].matches("xxx")) {
                perintah.add(input);
                if (in[0].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[i])); i++) {
                        if (cekObjekTabrakTembok(player, "u")) {
                            return;    
                        } else {
                            player.Gerak(0, -jarak);
                            repaint();
                        }

                    }
                } else if(in[0].equalsIgnoreCase("d")){
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[i])); i++) {
                        if (cekObjekTabrakTembok(player, "d")) {
                            return;    
                        } else {
                            player.Gerak(0, jarak);
                            repaint();
                        }
                        
                    }
                    
                } else if(in[0].equalsIgnoreCase("r")){
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[i])); i++) {
                        if (cekObjekTabrakTembok(player, "r")) {
                            return;    
                        } else {
                            player.Gerak(jarak,0);
                            repaint();
                        }
                        
                    }
            } else if(in[0].equalsIgnoreCase("d")){
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[i])); i++) {
                        if (cekObjekTabrakTembok(player, "u")) {
                            return;    
                        } else {
                            player.Gerak(0, jarak);
                            repaint();
                        }
                        
                    }
            
                } else if(in[0].equalsIgnoreCase("l")){
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[i])); i++) {
                        if (cekObjekTabrakTembok(player, "u")) {
                            return;    
                        } else {
                            player.Gerak(0, jarak);
                            repaint();
                        }
                        
                    }
    }
        }
    }

    private boolean cekObjekTabrakTembok(Pixel pemain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("1")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.posisiKiriObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("1")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.posisiKananObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("1")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.posisiAtasObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("1")) {
            for (int i = 0; i < tembok.size(); i++) {
                Tembok wall = (Tembok) tembok.get(i);
                if (pemain.posisiBawahObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        }
        return bantu;
    }
    
    
    
    
    
}
