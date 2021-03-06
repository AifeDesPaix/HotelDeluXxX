package src.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.Launcher.Launcher;

import java.io.IOException;

public class MenuMaintenance {
	
	private BorderPane root = Launcher.getRoot();
	
	public void openListeDemandes() throws IOException {
		try {
			FXMLLoader loaderListeDemandes = new FXMLLoader(getClass().getResource("/src/Views/listeDemandes.fxml"));
			AnchorPane menuMaintenance;
			menuMaintenance = loaderListeDemandes.load();
			root.setCenter(menuMaintenance);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void openListeRapports() throws IOException {
		try {
			FXMLLoader loaderListeRapports = new FXMLLoader(getClass().getResource("/src/Views/listeRapports.fxml"));
			AnchorPane menuMaintenance;
			menuMaintenance = loaderListeRapports.load();
			root.setCenter(menuMaintenance);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void openNewDemande() throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("src/Views/newDemande.fxml"));
		openWindowNewDemande(root);
	}
	
	public static void openWindowNewDemande(Parent root) throws IOException
    {
        Stage stage = new Stage();
        stage.setTitle("Nouvelle demande de maintenance");
        stage.getIcons().add(new Image("/src/image/Hotel/favicon.png"));
        stage.setScene(new Scene(root,800, 700));
        stage.show();
        
    }

}
