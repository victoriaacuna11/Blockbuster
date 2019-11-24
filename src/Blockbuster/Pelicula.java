/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockbuster;

/**
 *
 * @author victoriaacuna
 */
public class Pelicula {
    
    private String name, genre, date, CI;
    private int ID;

    public Pelicula(String name, String genre, int ID) {
        this.name = name;
        this.genre = genre;
        this.ID = ID;
        this.CI= "";
        this.date="";
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getID() {
        return ID;
    }

    public void setID(int index) {
        this.ID = index;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }
    
    
    
}
