/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author HP
 */
public class UserSession {
     private static UserSession instance;

    private String currentLogin;
    

    private UserSession() {
        
        
    }

    public static UserSession getInstance() {
        if(instance == null) {
            instance = new UserSession();
        }
        return instance;
    }

    public String getCurrentLogin() {
        return currentLogin;
    }

    
    public void setCurrentLogin(String currentLogin){
        this.currentLogin=currentLogin;
    }
    public void cleanUserSession() {
        currentLogin = "";
        
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "current Login='" + currentLogin  +'}';
    }
}
