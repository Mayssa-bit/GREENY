/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import java.sql.JDBCType;
import java.util.Objects;

/**
 *
 * @author mayssa
 */
public class Event {
    private int idEvenement;
    private String nomEvenement;
    private String adresse;
    private Date dateDebut;
    private Date dateFin;
    private String etat;
    private int nbPlace;
    private int nbStand;
    private double prix;
    private String image;

    public Event(int idEvenement, String nomEvenement, String adresse, Date dateDebut, Date dateFin, String etat, int nbPlace,int nbStand, double prix,String image) {
        this.idEvenement = idEvenement;
        this.nomEvenement = nomEvenement;
        this.adresse = adresse;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
        this.nbPlace = nbPlace;
        this.nbStand= nbStand;
        this.prix = prix;
        this.image=image;
    }

    public Event(String nomEvenement, String adresse, Date dateDebut, Date dateFin, String etat, int nbPlace,int nbStand, double prix,String image) {
        this.nomEvenement = nomEvenement;
        this.adresse = adresse;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
        this.nbPlace = nbPlace;
        this.nbStand=nbStand;
        this.prix = prix;
        this.image=image;
    }
    
    public Event() {
       
    }

    /*public Event(String greeny, String nasr, JDBCType jdbcType, JDBCType jdbcType0, String en_Cours, int i, int i0, int i1, String tgv) {
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public int getIdEvenement() {
        return idEvenement;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public String getNomEvenement() {
        return nomEvenement;
    }

    public void setNomEvenement(String nomEvenement) {
        this.nomEvenement = nomEvenement;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    

    

    

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getNbStand() {
        return nbStand;
    }

    public void setNbStand(int nbStand) {
        this.nbStand = nbStand;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Evenement{" + "idEvenement=" + idEvenement + ", nomEvenement=" + nomEvenement + ", adresse=" + adresse + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", etat=" + etat + ", nbPlace=" + nbPlace + ", nbStand=" + nbStand + ", prix=" + prix + ", image=" + image + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idEvenement;
        hash = 47 * hash + Objects.hashCode(this.nomEvenement);
        hash = 47 * hash + Objects.hashCode(this.adresse);
        hash = 47 * hash + Objects.hashCode(this.dateDebut);
        hash = 47 * hash + Objects.hashCode(this.dateFin);
        hash = 47 * hash + Objects.hashCode(this.etat);
        hash = 47 * hash + this.nbPlace;
        hash = 47 * hash + this.nbStand;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.prix) ^ (Double.doubleToLongBits(this.prix) >>> 32));
        hash = 47 * hash + Objects.hashCode(this.image);
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
        final Event other = (Event) obj;
        if (this.idEvenement != other.idEvenement) {
            return false;
        }
        if (this.nbPlace != other.nbPlace) {
            return false;
        }
        if (this.nbStand != other.nbStand) {
            return false;
        }
        if (Double.doubleToLongBits(this.prix) != Double.doubleToLongBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.nomEvenement, other.nomEvenement)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (!Objects.equals(this.image, other.image)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        return true;
    }

   
}
