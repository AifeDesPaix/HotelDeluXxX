package src.Metier;

import javax.persistence.*;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import src.Persistance.AccesData;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
public class Client extends RecursiveTreeObject<Client>{
    private int id;
    private String nom;
    private String prenom;
    private String adresseRue;
    private String adresseVille;
    private String codePostal;
    private String telephone;
    private Date dateNaissance;
    private String allergies;

    
    public Client(int id, String nom, String prenom, String adresseRue, String adresseVille, String codePostal,
			String telephone, Date dateNaissance, String allergies) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseRue = adresseRue;
		this.adresseVille = adresseVille;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.allergies = allergies;
	}

	public Client(String nom, String prenom, String adresseRue, String adresseVille, String codePostal,
			String telephone, Date dateNaissance, String allergies) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresseRue = adresseRue;
		this.adresseVille = adresseVille;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.allergies = allergies;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresseRue=" + adresseRue
				+ ", adresseVille=" + adresseVille + ", codePostal=" + codePostal + ", telephone=" + telephone
				+ ", allergies=" + allergies + "]";
	}

	public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }


    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom", nullable = false, length = 250)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = false, length = 250)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "adresse_rue", nullable = false, length = 250)
    public String getAdresseRue() {
        return adresseRue;
    }

    public void setAdresseRue(String adresseRue) {
        this.adresseRue = adresseRue;
    }

    @Basic
    @Column(name = "adresse_ville", nullable = false, length = 250)
    public String getAdresseVille() {
        return adresseVille;
    }

    public void setAdresseVille(String adresseVille) {
        this.adresseVille = adresseVille;
    }

    @Basic
    @Column(name = "code_postal", nullable = false, length = 20)
    public String getCodePostal() {
        return codePostal;
    }
    
    @Basic
    @Column(name = "date_naissance")
    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }


    @Basic
    @Column(name = "telephone", nullable = false, length = 25)
    public String getTelephone() {
        return telephone;
    }


    @Basic
    @Column(name = "allergies", nullable = false, length = 250)
    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

//    @OneToMany(mappedBy = "clientByIdClient")
//    public Collection<ClientAgenceAssoc> getClientAgenceAssocsById() {
//    	System.out.println(clientAgenceAssocsById);
//        return clientAgenceAssocsById;
//    }
//
//    public void setClientAgenceAssocsById(Collection<ClientAgenceAssoc> clientAgenceAssocsById) {
//        this.clientAgenceAssocsById = clientAgenceAssocsById;
//    }
//
//    @OneToMany(mappedBy = "clientByIdClient")
//    public Collection<FacturationAssoc> getFacturationAssocsById() {
//        return facturationAssocsById;
//    }
//
//    public void setFacturationAssocsById(Collection<FacturationAssoc> facturationAssocsById) {
//        this.facturationAssocsById = facturationAssocsById;
//    }


}
