/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entites;

/**
 *
 * @author HIDOUS MAYSSA
 */
public class Reservation {

    private int id;
    private int idevent;
    private int iduser;
    private int nbp;

    public Reservation(int idevent, int iduser, int nbp) {
        this.idevent = idevent;
        this.iduser = iduser;
        this.nbp = nbp;
    }

    public Reservation(int id, int idevent, int iduser, int nbp) {
        this.id = id;
        this.idevent = idevent;
        this.iduser = iduser;
        this.nbp = nbp;
    }

    public Reservation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdevent() {
        return idevent;
    }

    public void setIdevent(int idevent) {
        this.idevent = idevent;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getNbp() {
        return nbp;
    }

    public void setNbp(int nbp) {
        this.nbp = nbp;
    }

}
