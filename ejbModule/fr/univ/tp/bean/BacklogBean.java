package fr.univ.tp.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;

import fr.univ.tp.dao.EntreeDao;
import fr.univ.tp.entity.Agence;
import fr.univ.tp.entity.Entree;
import fr.univ.tp.entity.Utilisateur;

public class BacklogBean {
	
	@ManagedProperty(value = "#{param.agencyId}") /** ADD agencyId in URL..(NavigationBean..) */
	private Long agencyId;


	@EJB
	private EntreeDao entreeDao;
	private Utilisateur connectedUser; /** FIXE ME HOW TO GET CONNECTED USER ? IN URI ? OR IN SESSION ?*/
	private Agence agence;
	private List<Entree> entryList;
	
	public BacklogBean(){}
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	public Utilisateur getConnectedUser() {
		return connectedUser;
	}
	public void setConnectedUser(Utilisateur connectedUser) {
		this.connectedUser = connectedUser;
	}
	public List<Entree> getEntryList() {
		return entryList;
	}
	public void setEntryList(List<Entree> entryList) {
		this.entryList = entryList;
	}

}
