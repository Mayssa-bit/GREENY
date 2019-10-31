/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author g
 */
public class Commandes1 {
    private int Idc ;
    private int Idu ; 
    private int Idp ;
    private String prodname ;
    private String adresse ;
    private String email ;
    private int numu ; 
    private int quantité ;
    private int Prixcom;
    private Date datec ;
    private Date Datear ;
    private String nom ;
    private String prenom ;
    private String image;
    private int prixprod;
    private String Validation ;

    public Commandes1(int Idc, int Idu, int Idp, String prodname, String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom, String image, int prixprod, String Validation) {
        this.Idc = Idc;
        this.Idu = Idu;
        this.Idp = Idp;
         this.adresse = adresse;
        this.email = email;
        
       
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
        this.prodname = prodname;
        this.image = image;
        this.prixprod = prixprod;
        this.Validation = Validation;
    }

    public Commandes1(String prodname,int quantité, Date datec, Date Datear, int prixprod) {
        this.prodname = prodname;
        this.quantité = quantité;
        this.datec = datec;
        this.Datear = Datear;
        this.prixprod = prixprod;
    }

    public Commandes1(int Idu, int Idp, String prodname, String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom, String image, int prixprod, String Validation) {
        this.Idu = Idu;
        this.Idp = Idp;
        this.prodname = prodname;
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.prixprod = prixprod;
        this.Validation = Validation;
    }
    
    public Commandes1(String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom) {
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Commandes1() {
    }

    public Commandes1( String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom, String prodname, String image, int prixprod, String Validation) {
        
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.prodname = prodname;
        this.prixprod = prixprod;
        this.Validation = Validation;
    }

    public Commandes1(int Idc, int Idu, int Idp, String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom,String prodname) {
        this.Idc = Idc;
        this.Idu = Idu;
        this.Idp = Idp;
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
        this.prodname=prodname;
    }

    public Commandes1(String prodname, int quantité, Date Datear, int prixprod) {
        this.prodname = prodname;
        this.quantité = quantité;
        this.Datear = Datear;
        this.prixprod = prixprod;
    }

    public Commandes1(int Idu, int Idp, String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom) {
        this.Idu = Idu;
        this.Idp = Idp;
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Commandes1(int Idc, int Idu, int Idp, String prodname, String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom) {
        this.Idc = Idc;
        this.Idu = Idu;
        this.Idp = Idp;
        this.prodname = prodname;
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Commandes1(int Idc, int Idu, int Idp, String prodname, String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom, int prixprod) {
        this.Idc = Idc;
        this.Idu = Idu;
        this.Idp = Idp;
        this.prodname = prodname;
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
        this.prixprod = prixprod;
    }

   
    

   

  

    public int getIdc() {
        return Idc;
    }

    public int getIdu() {
        return Idu;
    }

    public int getIdp() {
        return Idp;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    public int getNumu() {
        return numu;
    }

    public int getQuantité() {
        return quantité;
    }

    public int getPrixcom() {
        return Prixcom;
    }

    public Date getDatec() {
        return datec;
    }

    public Date getDatear() {
        return Datear;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setIdc(int Idc) {
        this.Idc = Idc;
    }

    public void setIdu(int Idu) {
        this.Idu = Idu;
    }

    public void setIdp(int Idp) {
        this.Idp = Idp;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumu(int numu) {
        this.numu = numu;
    }

    public void setQuantité(int quantité) {
        this.quantité = quantité;
    }

    public void setPrixcom(int Prixcom) {
        this.Prixcom = Prixcom;
    }

    public void setDatec(Date datec) {
        this.datec = datec;
    }

    public void setDatear(Date Datear) {
        this.Datear = Datear;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Commandes{" + "Idc=" + Idc + ", Idu=" + Idu + ", Idp=" + Idp + ", prodname=" + prodname + ", adresse=" + adresse + ", email=" + email + ", numu=" + numu + ", quantit\u00e9=" + quantité + ", Prixcom=" + Prixcom + ", datec=" + datec + ", Datear=" + Datear + ", nom=" + nom + ", prenom=" + prenom + ", image=" + image + ", prixprod=" + prixprod + ", Validation=" + Validation + '}';
    }

    public Commandes1(String prodname, int quantité, int Prixcom, Date datec, Date Datear, String image, String Validation) {
        this.prodname = prodname;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.image = image;
        this.Validation = Validation;
    }

    


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.Idc;
        hash = 97 * hash + this.Idu;
        hash = 97 * hash + this.Idp;
        hash = 97 * hash + Objects.hashCode(this.adresse);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + this.numu;
        hash = 97 * hash + this.quantité;
        hash = 97 * hash + this.Prixcom;
        hash = 97 * hash + Objects.hashCode(this.datec);
        hash = 97 * hash + Objects.hashCode(this.Datear);
        hash = 97 * hash + Objects.hashCode(this.nom);
        hash = 97 * hash + Objects.hashCode(this.prenom);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Commandes1 other = (Commandes1) obj;
        if (this.Idc != other.Idc) {
            return false;
        }
        if (this.Idu != other.Idu) {
            return false;
        }
        if (this.Idp != other.Idp) {
            return false;
        }
        if (this.numu != other.numu) {
            return false;
        }
        if (this.quantité != other.quantité) {
            return false;
        }
        if (this.Prixcom != other.Prixcom) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.datec, other.datec)) {
            return false;
        }
        if (!Objects.equals(this.Datear, other.Datear)) {
            return false;
        }
        return true;
    }

    public String getImage() {
        return image;
    }

    public String getProdname() {
        return prodname;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public Commandes1(int Idc, int Idu, int Idp, String prodname, String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom, String image) {
        this.Idc = Idc;
        this.Idu = Idu;
        this.Idp = Idp;
        this.prodname = prodname;
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
    }

    public Commandes1(int Idc, int Idu, int Idp, String prodname, String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom, String image, int prixprod) {
        this.Idc = Idc;
        this.Idu = Idu;
        this.Idp = Idp;
        this.prodname = prodname;
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.prixprod = prixprod;
    }





    public int getPrixprod() {
        return prixprod;
    }

    public void setPrixprod(int prixprod) {
        this.prixprod = prixprod;
    }

    public Commandes1(int Idu, int Idp, String prodname, String adresse, String email, int numu, int quantité, int Prixcom, Date datec, Date Datear, String nom, String prenom, String image, int prixprod) {
        this.Idu = Idu;
        this.Idp = Idp;
        this.prodname = prodname;
        this.adresse = adresse;
        this.email = email;
        this.numu = numu;
        this.quantité = quantité;
        this.Prixcom = Prixcom;
        this.datec = datec;
        this.Datear = Datear;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
        this.prixprod = prixprod;
    }

    public String getValidation() {
        return Validation;
    }

    public void setValidation(String Validation) {
        this.Validation = Validation;
    }

           
}
