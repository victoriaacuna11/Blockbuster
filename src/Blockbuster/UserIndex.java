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
public class UserIndex {
    
    private int userCI, arrayIndex;
    private String userLiteralCI;

    public UserIndex(int userCI, int arrayIndex, String userLiteralCI) {
        this.userCI = userCI;
        this.arrayIndex = arrayIndex;
        this.userLiteralCI = userLiteralCI;
    }
    
    public String getUserLiteralCI() {
        return userLiteralCI;
    }

    public void setUserLiteralCI(String userLiteralCI) {
        this.userLiteralCI = userLiteralCI;
    }

    public int getUserCI() {
        return userCI;
    }

    public void setUserCI(int userIndex) {
        this.userCI = userIndex;
    }

    public int getArrayIndex() {
        return arrayIndex;
    }

    public void setArrayIndex(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }
    
    
}
