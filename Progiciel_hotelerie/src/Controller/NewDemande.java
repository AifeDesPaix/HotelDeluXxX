package src.Controller;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import src.Metier.Criticite;
import src.Metier.DemandeIntervention;
import src.Metier.EquipementHotel;
import src.Metier.EquipementRestaurant;
import src.Metier.EquipementSpa;
import src.Persistance.Maintenance.AccesDataNewDemande;

public class NewDemande implements Initializable {
	
	@FXML private JFXTabPane onglets;
	@FXML private JFXComboBox etages;
	@FXML private JFXComboBox chambres;
	@FXML private JFXComboBox<EquipementHotel> equipementsHotel;
	@FXML private JFXComboBox<EquipementHotel> equipementsJardin;
	@FXML private JFXComboBox<EquipementRestaurant> equipementsRestaurant;
	@FXML private JFXComboBox<EquipementSpa> equipementsSpa;
	@FXML private JFXTextField objetField;
	@FXML private JFXTextArea descriptionField;
	@FXML private JFXComboBox<Criticite> criticite;
	@FXML private Text priseEnCharge;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// Charge la liste des �tages dans le combo box correspondant
		etages.getItems().addAll(AccesDataNewDemande.getListeEtages());
		
		// Charge la liste de toutes les chambres par d�faut
		// Une fois un �tage s�lectionn�, la liste des cjhambres sera recharg� et de m�me pour les �quipements
		chambres.getItems().addAll(AccesDataNewDemande.getListeChambres());
		
		// Charge la liste des �quipements
		equipementsHotel.getItems().addAll(AccesDataNewDemande.getListeEquipement());
		equipementsJardin.getItems().addAll(AccesDataNewDemande.getListeEquipementJardin());
		equipementsRestaurant.getItems().addAll(AccesDataNewDemande.getListeEquipementRestaurant());
		equipementsSpa.getItems().addAll(AccesDataNewDemande.getListeEquipementSpa());
		
		// Charge la liste des criticit�
		criticite.getItems().addAll(AccesDataNewDemande.getListeCriticite());
	}
	
	public void tempsPriseEnCharge() {
		priseEnCharge.setText("Temps de prise en charge : " + criticite.getValue().getTempsMaximum().toString());
	}
	
	/**
	 * Permet de cr�er une demande � partir des �l�ments renseign�s dans la fen�tre
	 */
	public void createDemande() {
		System.out.println("Objet : " + objetField.getText());
		System.out.println("Description : " + descriptionField.getText());
		System.out.println("Criticit� : " + criticite.getValue());
		System.out.println("Equipement : " + equipementsHotel.getValue());
		
		// Cr�ation de la demande
		DemandeIntervention newDemande = new DemandeIntervention(
				new Date(0), //date de cr�ation
				objetField.getText(),
				descriptionField.getText(),
				true, //valide
				criticite.getValue(),
				null, //spa
				(EquipementHotel) equipementsHotel.getValue(),
				null, //restaurant
				null, //pi�ce de rechange
				null, //demande utilisateur
				null //rapport
				);
		//Persistance dans la base
		AccesDataNewDemande.ajouterDemande(newDemande);
	}
	
	/**
	 * Filtre les autres combo box en fonction de l'�tage s�lectionn�
	 */
	public void filterEtage() {
		chambres.getItems().clear();
		chambres.getItems().addAll(AccesDataNewDemande.getListeChambres((int) etages.getValue()));
		equipementsHotel.getItems().clear();
		equipementsHotel.getItems().addAll(AccesDataNewDemande.getListeEquipementByEtage((int) etages.getValue()));
	}
	
	/**
	 * Filtre la liste des �quipements en fonction de la chambre s�lectionn�e
	 */
	public void filterChambre() {
		equipementsHotel.getItems().clear();
		equipementsHotel.getItems().addAll(AccesDataNewDemande.getListeEquipementByChambre((int) chambres.getValue()));
	}
	
	public void changeLocationEquipement() {
		System.out.println(onglets.toString());
	}
}
