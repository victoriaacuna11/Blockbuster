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
public class MovieIndex {
    
    private int movieID, arrayIndex;

    public MovieIndex(int movieID, int arrayIndex) {
        this.movieID = movieID;
        this.arrayIndex = arrayIndex;
    }
    

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieIndex) {
        this.movieID = movieIndex;
    }

    public int getArrayIndex() {
        return arrayIndex;
    }

    public void setArrayIndex(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }
    
    
}
