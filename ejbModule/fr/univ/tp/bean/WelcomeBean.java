package fr.univ.tp.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

import fr.univ.tp.dao.AgenceDao;
import fr.univ.tp.entity.Agence;
import fr.univ.tp.entity.Utilisateur;

@Named
@RequestScoped
public class WelcomeBean implements Serializable {
	private static final long serialVersionUID = -8420604818625234910L;

	@ManagedProperty(value = "#{param.id}")
	private Long id;

	@EJB
	private AgenceDao agenceDao;
	private Utilisateur connectedUser; /** FIXE ME HOW TO GET CONNECTED USER ? IN URI ? OR IN SESSION ?*/
	private List<Agence> agencyList;
	private String agencyName;
	
	public void createAgency(String agencyName){
		Agence newAgency = agenceDao.creerAgence(agencyName, connectedUser.getId());
		
		if (newAgency != null) {
			System.out.println("creerAgence OK");
		}
		
		//Set ERROR 
		// FacesMessage msg = new FacesMessage("erreur lors la creation de l'agence!", "ERROR MSG");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// FacesContext.getCurrentInstance().addMessage(null, msg);

		// To to login page
		System.out.println("creerAgence Not OK");
	}
	public WelcomeBean() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Utilisateur getConnectedUser() {
		return connectedUser;
	}



	public void setConnectedUser(Utilisateur connectedUser) {
		this.connectedUser = connectedUser;
	}



	public List<Agence> getAgencyList() {
		return agenceDao.getUserAgency(connectedUser.getId());
	}

	public void setAgencyList(List<Agence> agencyList) {
		this.agencyList = agencyList;
	}



	public String getAgencyName() {
		return agencyName;
	}



	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

}
