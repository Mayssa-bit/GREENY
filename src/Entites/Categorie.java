/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author ASUS
 */
public class Categorie {
    
    private int id_cath;
    private String nom_cath;
    private String nom_latin;

    
    public Categorie(){}
    
    public Categorie (int id_cath,String nom_cath,String nom_latin){
        
    this.id_cath=id_cath;
    this.nom_cath=nom_cath;
    this.nom_latin=nom_latin;
   
    }

   

   

    public int getId_cath() {
        return id_cath;
    }

    public void setId_cath(int id_cath) {
        this.id_cath = id_cath;
    }

    public String getNom_cath() {
        return nom_cath;
    }

    public void setNom_cath(String nom_cath) {
        this.nom_cath = nom_cath;
    }
     public String getNom_latin() {
        return nom_latin;
    }

    public void setNom_latin(String nom_latin) {
        this.nom_latin = nom_latin;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_cath=" + id_cath + ", nom_cath=" + nom_cath + ", nom_latin=" + nom_latin+ '}';
    }
    
    
}
