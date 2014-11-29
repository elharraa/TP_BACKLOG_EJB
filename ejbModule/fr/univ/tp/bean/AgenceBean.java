package fr.univ.tp.bean;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

import fr.univ.tp.dao.UtilisateurDao;
import fr.univ.tp.entity.Utilisateur;

@Named
@RequestScoped
public class AgenceBean implements Serializable {
	private static final long serialVersionUID = -8420604818625234910L;

	@EJB
	private UtilisateurDao utilisateurDao;

	@ManagedProperty(value = "#{param.id}")
	private Long id;


	private List<Utilisateur> listUsers;

	public AgenceBean() {
	}

	public List<Utilisateur> getListUsers() {
		return utilisateurDao.getUsers();
	}

	public void setListUsers(List<Utilisateur> listUsers) {
		this.listUsers = listUsers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
