package fr.univ.tp.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class NavigationBean implements Serializable {

	private static final long serialVersionUID = 1520318172495977648L;

	/**
	 * Redirect to login page.
	 * @return Login page name.
	 */
	public String redirectToLogin() {
		return "/login.xhtml?faces-redirect=true";
	}
	
	/**
	 * Go to login page.
	 * @return Login page name.
	 */
	public String toLogin() {
		return "/login.xhtml";
	}
	
	/**
	 * Redirect to info page.
	 * @return Info page name.
	 */
	public String redirectToSignUp() {
		return "/signup.xhtml?faces-redirect=true";
	}
	
	/**
	 * Redirect to welcome page.
	 * @return Welcome page name.
	 */
	public String redirectToWelcome() {
		return "/secured/welcome.xhtml?faces-redirect=true";
	}
	
	/**
	 * Go to welcome page.
	 * @return Welcome page name.
	 */
	public String toWelcome() {
		return "/secured/welcome.xhtml";
	}
	
	/**
	 * Redirect to backlog page.
	 * @return Backlog page name.
	 */
	public String redirectToBacklog() {
		return "/secured/backlog.xhtml";
	}
	
	public NavigationBean(){}
}