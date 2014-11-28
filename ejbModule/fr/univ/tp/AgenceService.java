package fr.univ.tp;

public interface AgenceService {
	public Agence creerAgence(String name);
	public void ajoutEntree(Long idAgence, Entree entree);
	public void supprimeEntree(Long idAgence, Long idEntree);
	public Agence chercheAgence(Long id);
}
