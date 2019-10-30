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
public class User {
     private int id;
    private String nom;
    private String prenom;
    private String login;
    private String mps;
    private int cin;
    private String adresse;
    private String email;
    private int phone;
    private String type;
    private int score;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(String nom, String prenom, String mps, String adresse, int phone) {
        this.nom = nom;
        this.prenom = prenom;
        this.mps = mps;
        this.adresse = adresse;
        this.phone = phone;
    }

    public User(String nom, String prenom,String login, String mps, String adresse, String email, int phone, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.mps = mps;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.login=login;
    }

    public User(int id,String nom, String prenom, String login, String mps, String adresse, String email, int phone, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mps = mps;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
        this.type = type;
        this.id=id;
    }

    public User(int id, String nom, String prenom, String login, String mps, int cin, String adresse, String email, int phone, String type) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mps = mps;
        this.cin = cin;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

   
    

    public User(String nom, String prenom, String login, String mps, int cin, String adresse, String email, int phone, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.mps = mps;
        this.cin = cin;
        this.adresse = adresse;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMps() {
        return mps;
    }

    public void setMps(String mps) {
        this.mps = mps;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mps=" + mps + ", cin=" + cin + ", adresse=" + adresse + ", email=" + email + ", phone=" + phone + ", type=" + type + '}';
    }
    
    
}
