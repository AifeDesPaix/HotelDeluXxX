package src.Controller;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.cfg.Configuration;
import javafx.fxml.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import src.Metier.Client;
import src.Persistance.AccesData;

public class HebergementClients implements Initializable {
	
	/**
	 * D�claration des objets pr�sents dans la vue pour y ajouter des �v�nements
	 */
	@FXML private AnchorPane hebergementClientPane;
	@FXML private JFXTreeTableView<Client> tableHebergementClient;
	@FXML private JFXTreeTableColumn<Client, String> nom;
	@FXML private JFXTextField txtName;
	@FXML private JFXTextField txtPrenom;
	@FXML private JFXTextField txtAdresse;
	@FXML private JFXTextField txtPhone;
	
	/**
	 * D�claration de la liste d'observables qui contiendra les objets a afficher dans le tableau
	 */
	private ObservableList<Client> listeClients = FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		/**
		 * R�cup�re la liste de tous les clients		
		 */
		List<Client> listec = AccesData.getClients();
		
		/**
		 * Ajoute chaque client r�cup�r� � la liste d'observable de clients
		 */
		for(Client c : listec){
			listeClients.add(c);
		}
		
		/**
		 * Cr�� l'arbre d'objets avec la liste d'observables de clients
		 */
		final TreeItem<Client> root = new RecursiveTreeItem<Client>(listeClients, RecursiveTreeObject::getChildren);	
		
		
		/**
		 * Cr�� la colonne en la nommant, d�finie sa taille par d�fault puis Ajoute une valeur � la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> nom = new JFXTreeTableColumn<>("Nom");
		nom.setPrefWidth(100);
		nom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getNom()));
		
		/**
		 * Cr�� la colonne en la nommant, d�finie sa taille par d�fault puis Ajoute une valeur � la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> prenom = new JFXTreeTableColumn<>("Pr�nom");
		prenom.setPrefWidth(100);
		prenom.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPrenom()));
		
		/**
		 * Cr�� la colonne en la nommant, d�finie sa taille par d�fault puis Ajoute une valeur � la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> adresse = new JFXTreeTableColumn<>("Adresse");
		adresse.setPrefWidth(100);
		adresse.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getAdresseRue() + ", " + param.getValue().getValue().getAdresseVille() + ", " + param.getValue().getValue().getCodePostal()));
		
		/**
		 * Cr�� la colonne en la nommant, d�finie sa taille par d�fault puis Ajoute une valeur � la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> telephone = new JFXTreeTableColumn<>("T�l�phone");
		telephone.setPrefWidth(100);
		telephone.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getTelephone()));
		
		/**
		 * Cr�� la colonne en la nommant, d�finie sa taille par d�fault puis Ajoute une valeur � la ligne (boucle sur la liste d'observables
		 */
		JFXTreeTableColumn<Client, String> chambre = new JFXTreeTableColumn<>("Chambre actuelle");
		chambre.setPrefWidth(100);		
		chambre.setCellValueFactory(param -> new SimpleStringProperty(AccesData.getChambreClientActuelle(param.getValue().getValue().getId())));
		
		/**
		 * Ajoute l'arbre de clients au panel
		 */
		tableHebergementClient.setRoot(root);
		tableHebergementClient.setShowRoot(false);
		
		/**
		 * R�cup�re les colonnes du tableau puis ajoute les nouvelles colonnes pr�c�demment d�clar�es
		 */
		tableHebergementClient.getColumns().setAll(nom,prenom,adresse,telephone,chambre);

	}
	
	/**
	 * Fonction de recherche lors du clique sur rechercher
	 */
	public void search(){
		/**
		 * Vide la liste d'observable de clients
		 */
		listeClients.clear();
		
		/**
		 * Ajoute dans une liste tous les clients correspondant au filtre apr�s avoir fait la requ�te n�cessaire
		 */
		List<Client> listeClient = null;
		if(!txtName.getText().equals("")){
			listeClient = AccesData.getClientsByName(txtName.getText());
		} else if (!txtPrenom.getText().equals("")){
			listeClient = AccesData.getClientsByPrenom(txtPrenom.getText());
		} else if (!txtAdresse.getText().equals("")){
			listeClient = AccesData.getClientsByAdresse(txtAdresse.getText());
		} else if (!txtPhone.getText().equals("")){
			listeClient = AccesData.getClientsByPhone(txtPhone.getText());
		}
		
		/**
		 * Ajoute les clients � la liste d'observables pour qu'ils soient affich�s
		 */
		if(listeClient.size() > 0){
			for(Client c : listeClient){
				listeClients.add(c);
			}
		}
	}
	
}
