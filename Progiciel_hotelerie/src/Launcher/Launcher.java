package src.Launcher;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import src.Persistance.AccesData;

import java.net.URL;


public class Launcher extends Application {
	/**
	 * Declaration du border Pan principale.
	 */
	private static BorderPane root = new BorderPane();
	
	public static BorderPane getRoot() {
	    return root;
	  }
	
	public void start(Stage primaryStage) {
		try {
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("/src/Views/menu.fxml"));
//			AnchorPane menu = loader.load();
//			root.setTop(menu);

			//FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/src/Views/login.fxml"));
			primaryStage.getIcons().add(new Image("file:Progiciel_hotelerie/src/image/Hotel/favicon.png"));
			primaryStage.setTitle("Grand Hôtel du Parc");

			URL login = getClass().getResource("/src/Views/login.fxml");
			AnchorPane login2 = FXMLLoader.load(login);
			root.setCenter(login2);
	        
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			System.out.println(AccesData.getChambreClientActuelle(1));
//			loader.setLocation(getClass().getResource("/src/Views/login.fxml"));
//			Parent content = loader.load();
//			root.setTop(content);
//			primaryStage.show();
			//final String dir = System.getProperty("user.dir");
			///String chemin = AccesData.getEquipementHotel(1).getPhoto();
	        //System.out.println("current dir = " + dir + File.separator + "src" + File.separator + chemin);
//	        Path path = Paths.get(dir + File.separator + "src" + File.separator + chemin);
//	        System.out.println(path.getFileName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
