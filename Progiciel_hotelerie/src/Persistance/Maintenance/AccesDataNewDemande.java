package src.Persistance.Maintenance;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import src.Metier.Criticite;
import src.Metier.DemandeIntervention;
import src.Metier.EquipementHotel;
import src.Metier.EquipementRestaurant;
import src.Metier.EquipementSpa;
import src.Persistance.HibernateSession;

import java.util.List;

public class AccesDataNewDemande {
	
	private static Session s = HibernateSession.getSession();
	private static Transaction t;
	
	/**
	 *  Ajoute la nouvelle demande dans la base
	 * @param newDemande la demande créée dans la fenêtre
	 */
	public static void ajouterDemande(DemandeIntervention newDemande) {
		System.out.println(newDemande);
		try {
			t = s.beginTransaction();
			s.save(newDemande);
			t.commit();
		} catch (org.hibernate.HibernateException e) {
			System.err.println("Erreur Hibernate : " + e.getMessage());
		}
	}
	
	/**
	 * @return la liste de tous les étages de l'hôtel
	 */
	public static List<Integer> getListeEtages() {
		List<Integer> listeEtage = s.createQuery("SELECT distinct etage FROM Chambre").list();
		return listeEtage;
	}
	
	/**
	 * @return la liste de toutes les chambres de l'hôtel
	 */
	public static List<Integer> getListeChambres() {
		List<Integer> listeChambres = s.createQuery("SELECT id FROM Chambre").list();
		return listeChambres;
	}
	
	/**
	 * @param etage
	 * @return la liste de toutes les chambres à un étage donné
	 */
	public static List<Integer> getListeChambres(int etage) {
		Query query = s.createQuery("SELECT id FROM Chambre WHERE etage = :etage");
		query.setInteger("etage", etage);
		List<Integer> listeChambres = query.list();
		return listeChambres;
	}
	
	/**
	 * @return la liste de tous les équipements de l'hôtel
	 */
	public static List<EquipementHotel> getListeEquipement() {
		List<EquipementHotel> listeEquipements = s.createQuery("FROM EquipementHotel").list();
		return listeEquipements;
	}
	
	/**
	 * @param etage
	 * @return la liste de tous les équipements d'un étage donné
	 */
	public static List<EquipementHotel> getListeEquipementByEtage(int etage) {
		Query query = s.createQuery("SELECT eh FROM EquipementHotel eh, Chambre c WHERE c.id = eh.chambreByIdChambre AND c.etage = :etage");
		query.setInteger("etage", etage);
		List<EquipementHotel> listeEquipements = query.list();
		return listeEquipements;
	}
	
	/**
	 * @param chambre
	 * @return la liste de tous les équipements d'une chambre donnée
	 */
	public static List<EquipementHotel> getListeEquipementByChambre(int chambre) {
		Query query =  s.createQuery("FROM EquipementHotel where chambreByIdChambre = :chambre");
		query.setInteger("chambre", chambre);
		List<EquipementHotel> listeEquipements = query.list();
		return listeEquipements;
	}
	
	/**
	 * @return la liste des criticités
	 */
	public static List<Criticite> getListeCriticite() {
		List<Criticite> listeCriticite = s.createQuery("FROM Criticite").list();
		return listeCriticite;
	}
	
	/**
	 * @return la liste de tous les équipements du jardin
	 */
	public static List<EquipementHotel> getListeEquipementJardin() {
		List<EquipementHotel> listeEquipements = s.createQuery("FROM EquipementHotel WHERE estEquipementJardin = 1").list();
		return listeEquipements;
	}
	
	/**
	 * @return la liste de tous les équipements du restaurant
	 */
	public static List<EquipementRestaurant> getListeEquipementRestaurant() {
		List<EquipementRestaurant> listeEquipements = s.createQuery("FROM EquipementRestaurant").list();
		return listeEquipements;
	}
	
	/**
	 * @return la liste de tous les équipements du spa
	 */
	public static List<EquipementSpa> getListeEquipementSpa() {
		List<EquipementSpa> listeEquipements = s.createQuery("FROM EquipementSpa").list();
		return listeEquipements;
	}
}
