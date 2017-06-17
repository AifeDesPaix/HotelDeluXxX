package src.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import src.Launcher.Launcher;
import src.Metier.Client;
import src.Metier.ReservationHotel;
import src.Persistance.AccesData;

public class ClientDetails implements Initializable {
	Client client = new Client();
	@FXML private Text lblName;
	@FXML private Text lblPhone;
	@FXML private Text lblBirth;
	@FXML private Text lblAddress;
	@FXML private JFXTextArea areaInfos;
	@FXML private Text lblResaChambre;
	@FXML private JFXTreeTableView<ReservationHotel> tableResaChambreClient;
	private ObservableList<ReservationHotel> listeReservationsHotel = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void setClient(Client client){
	    this.client = client;
	}
	public void update(){
		lblName.setText(this.client.getNom() + " " + this.client.getPrenom());
		lblPhone.setText("T�l�phone : " + this.client.getTelephone());
		lblBirth.setText("Date de naissance : " + this.client.getDateNaissance().toString());
		lblAddress.setText("Adresse : " + this.client.getAdresseRue() + " " + this.client.getAdresseVille() + " " + this.client.getCodePostal());
		areaInfos.setText(this.client.getAllergies());
		lblResaChambre.setText("R�servation en cours : " + AccesData.getChambreClientActuelle(this.client.getId()));
		
		
		
		List<ReservationHotel> listeR = AccesData.getReservationsClients(this.client.getId());
		for( ReservationHotel r : listeR){
			listeReservationsHotel.add(r);
		}
		final TreeItem<ReservationHotel> root = new RecursiveTreeItem<ReservationHotel>(listeReservationsHotel, RecursiveTreeObject::getChildren);	

		JFXTreeTableColumn<ReservationHotel, String> reservationNumber = new JFXTreeTableColumn<>("Num�ro de r�servation");
		reservationNumber.setPrefWidth(100);
		reservationNumber.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().getId())));
		
		JFXTreeTableColumn<ReservationHotel, String> beginDateResa = new JFXTreeTableColumn<>("Date de d'arriv�e");
		beginDateResa.setPrefWidth(100);
		beginDateResa.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().getDateDebut())));
		
		JFXTreeTableColumn<ReservationHotel, String> endDateResa = new JFXTreeTableColumn<>("Date de d�part");
		endDateResa.setPrefWidth(100);
		endDateResa.setCellValueFactory(param -> new SimpleStringProperty(String.valueOf(param.getValue().getValue().getDateFin())));
		
		tableResaChambreClient.setRoot(root);
		tableResaChambreClient.setShowRoot(false);
		tableResaChambreClient.getColumns().setAll(reservationNumber,beginDateResa,endDateResa);

	}
	
	public void editClient(){
		/**
    	 * Recupere la fenetre
    	 */
    	BorderPane rootPane = Launcher.getRoot();
    	/**
    	 * Charge la vue client details
    	 */
    	FXMLLoader loaderClientEdit = new FXMLLoader(getClass().getResource("/src/Views/editClient.fxml"));
			AnchorPane editClient;
		try {
			editClient = loaderClientEdit.load();
			rootPane.setCenter(editClient);
	        //System.out.println(c);
	        EditClient controllerEditClient = loaderClientEdit.<EditClient>getController();
	        controllerEditClient.setClient(this.client);
	        controllerEditClient.fieldContent();
	    } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	

}