package fr.univ.tp;

import java.util.Date;

public interface EntreeService {
	public Entree creerEntree(String name, Date date, int priority, int estimation, String description);
	public Entree chercheEntree(Long idEntree);
	public void modifierEntree(Long idEntree, String name, Date date, int priority, int estimation, String description);
	public void ajoutCommentaire(Long idEntree, String commentaire);
	public void supprimerEntree(Long idEntree);
}