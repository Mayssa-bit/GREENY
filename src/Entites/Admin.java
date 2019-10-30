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
public class Admin {
    private String Login;
    private String Password;

    public Admin() {
    }

    public Admin(String Login, String Password) {
        this.Login = Login;
        this.Password = Password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Admin{" + "Login=" + Login + ", Password=" + Password + '}';
    }
    
}
