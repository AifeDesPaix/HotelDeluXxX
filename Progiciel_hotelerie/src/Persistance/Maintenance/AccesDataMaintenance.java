package src.Persistance.Maintenance;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import src.Metier.Criticite;
import src.Metier.Etat;
import src.Persistance.HibernateSession;

public class AccesDataMaintenance {
	
	private static Session s = HibernateSession.getSession();
	private static Transaction t;
	
	/**
	 * @return la liste des tous les �tats
	 */
	public static List<Etat> getListeEtat() {
		List<Etat> listeEtat = s.createQuery("FROM Etat").list();		
		return listeEtat;
	}

	/**
	 * @return la liste des toutes les criticit�s
	 */
	public static List<Criticite> getListeCriticite() {
		List<Criticite> listeCriticite = s.createQuery("FROM Criticite").list();	
		return listeCriticite;
	}

}
