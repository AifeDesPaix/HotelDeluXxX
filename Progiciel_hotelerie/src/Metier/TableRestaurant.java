package src.Metier;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ledze on 17/05/2017.
 */
@Entity
@javax.persistence.Table(name = "table_restaurant", schema = "hotel", catalog = "")
public class TableRestaurant {
    private int id;
    private int nbCouverts;
    private Collection<EquipementRestaurant> equipementRestaurantsById;
    private Collection<ReservationRestaurant> reservationRestaurantsById;

    public TableRestaurant(int id, int nbCouverts, Collection<EquipementRestaurant> equipementRestaurantsById,
			Collection<ReservationRestaurant> reservationRestaurantsById) {
		super();
		this.id = id;
		this.nbCouverts = nbCouverts;
		this.equipementRestaurantsById = equipementRestaurantsById;
		this.reservationRestaurantsById = reservationRestaurantsById;
	}

	public TableRestaurant(int nbCouverts, Collection<EquipementRestaurant> equipementRestaurantsById,
			Collection<ReservationRestaurant> reservationRestaurantsById) {
		super();
		this.nbCouverts = nbCouverts;
		this.equipementRestaurantsById = equipementRestaurantsById;
		this.reservationRestaurantsById = reservationRestaurantsById;
	}

	public TableRestaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Table [id=" + id + ", nbCouverts=" + nbCouverts + ", equipementRestaurantsById="
				+ equipementRestaurantsById + ", reservationRestaurantsById=" + reservationRestaurantsById + "]";
	}

	public void setId(Integer id) {
        this.id = id;
    }

    public void setNbCouverts(Integer nbCouverts) {
        this.nbCouverts = nbCouverts;
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
    @Column(name = "nbCouverts", nullable = false)
    public int getNbCouverts() {
        return nbCouverts;
    }

    public void setNbCouverts(int nbCouverts) {
        this.nbCouverts = nbCouverts;
    }

    @OneToMany(mappedBy = "tableByIdTable")
    public Collection<EquipementRestaurant> getEquipementRestaurantsById() {
        return equipementRestaurantsById;
    }

    public void setEquipementRestaurantsById(Collection<EquipementRestaurant> equipementRestaurantsById) {
        this.equipementRestaurantsById = equipementRestaurantsById;
    }

    @OneToMany(mappedBy = "tableByIdTable")
    public Collection<ReservationRestaurant> getReservationRestaurantsById() {
        return reservationRestaurantsById;
    }

    public void setReservationRestaurantsById(Collection<ReservationRestaurant> reservationRestaurantsById) {
        this.reservationRestaurantsById = reservationRestaurantsById;
    }
}
