package src.Controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import src.Launcher.Launcher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuHebergement implements Initializable {

//	private String login;

//	@FXML private Text usernameLabel;

	@FXML private JFXButton btnClient;
	@FXML private JFXButton btnReservations;
	@FXML private JFXButton btnAgences;
	BorderPane root = Launcher.getRoot();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void accessToClient(){
		FXMLLoader loaderHebergementClients = new FXMLLoader(getClass().getResource("/src/Views/hebergementClients.fxml"));
			AnchorPane menuHebergementClients;
			try {
				menuHebergementClients = loaderHebergementClients.load();
				root.setCenter(menuHebergementClients);
			} catch (IOException e) {
				e.printStackTrace();
			}		
	}
	
	public void accessToReservation(){
		FXMLLoader loaderReservations = new FXMLLoader(getClass().getResource("/src/Views/reservationsList.fxml"));
		AnchorPane menuReservations;
		try {
			menuReservations = loaderReservations.load();
			root.setCenter(menuReservations);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void accessToAgences(){
		FXMLLoader loaderAgences = new FXMLLoader(getClass().getResource("/src/Views/agencesList.fxml"));
		AnchorPane menuAgence;
		System.out.println("aaazazazazaz");
		try {
			menuAgence = loaderAgences.load();
			root.setCenter(menuAgence);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Appelle la fonction dans le menu maintenance qui permet d'ouvrir la fenêtre de nouvelle demande
	 * @throws IOException
	 */
	public void openNewDemande() throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("src/Views/newDemande.fxml"));
		MenuMaintenance.openWindowNewDemande(root);
    }

}
