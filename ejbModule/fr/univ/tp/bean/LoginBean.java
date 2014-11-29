package fr.univ.tp.bean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fr.univ.tp.dao.UtilisateurDao;
import fr.univ.tp.entity.Utilisateur;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 7765876811740798583L;

	@EJB
	private UtilisateurDao utilisateurDao;

	private String email;
	private boolean loggedIn;

	// @ManagedProperty(value="#{navigationBean}")
	private NavigationBean navigationBean = new NavigationBean();;

	/**
	 * Login operation.
	 * 
	 * @return
	 */
	public String doLogin() {
		// Get every user from our sample database :)
		Utilisateur user = utilisateurDao.signIn(email);
		if (user != null) {
			loggedIn = true;
			System.out.println("Log OK");
			return navigationBean.redirectToWelcome();
		}
		
		/**
		 * FIXME NoClassDefFoundError: javax/faces/application/FacesMessage
		 * 
		 */
		//Set login ERROR 
		// FacesMessage msg = new FacesMessage("Login error!", "ERROR MSG");
		// msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		// FacesContext.getCurrentInstance().addMessage(null, msg);

		// To to login page
		System.out.println("Not OK");
		return navigationBean.toLogin();

	}

	/**
	 * Logout operation.
	 * 
	 * @return
	 */
	public String doLogout() {
		// Set the paremeter indicating that user is logged in to false
		loggedIn = false;

		// Set logout message
		FacesMessage msg = new FacesMessage("Logout success!", "INFO MSG");
		msg.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return navigationBean.toLogin();
	}

	// ------------------------------
	// Getters & Setters

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public NavigationBean getNavigationBean() {
		return navigationBean;
	}

	public LoginBean() {
	}

}