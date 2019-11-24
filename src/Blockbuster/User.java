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
public class User {
    private int phone;
    private String name, CI;
    public Pelicula[] peliculas;
    public boolean firstMovie;

    public User(int phone, String name, String CI) {
        this.phone = phone;
        this.name = name;
        this.CI = CI;
        this.firstMovie=false;
    }
    

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
