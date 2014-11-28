package fr.univ.tp;

import java.io.Serializable;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
//import javax.inject.Named;

//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
//@Named
//@RequestScoped
public class BonjourBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }
}