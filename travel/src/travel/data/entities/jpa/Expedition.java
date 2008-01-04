package travel.data.entities.jpa;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="travel", name="Expeditions")
public class Expedition implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="ExpeditionID")
	private Integer id;

	private Integer amountOfPlaces;

	private Date dateFrom;

	private Date dateTo;

	private Integer minPersons;

	private Timestamp dateStop;

	private String description;

	@ManyToOne
	@JoinColumn(name="OfferID")
	private Offer offer;

	@OneToMany(mappedBy="expedition")
	private Set<Remark> remarks;

	@OneToMany(mappedBy="expedition")
	private Set<Reservation> reservations;

	private static final long serialVersionUID = 1L;

	public Expedition() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmountOfPlaces() {
		return amountOfPlaces;
	}

	public void setAmountOfPlaces(Integer amountOfPlaces) {
		this.amountOfPlaces = amountOfPlaces;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public Integer getMinPersons() {
		return minPersons;
	}

	public void setMinPersons(Integer minPersons) {
		this.minPersons = minPersons;
	}

	public Timestamp getDateStop() {
		return dateStop;
	}

	public void setDateStop(Timestamp dateStop) {
		this.dateStop = dateStop;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Set<Remark> getRemarks() {
		return remarks;
	}

	public void setRemarks(Set<Remark> remarks) {
		this.remarks = remarks;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

}
