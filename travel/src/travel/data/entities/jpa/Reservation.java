package travel.data.entities.jpa;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import travel.commons.enums.ReservationStatus;


@Entity
@Table(schema="travel", name="reservations")
public class Reservation implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="ReservationID")
	private Integer id;

	private String description;

	@Enumerated(STRING)
	private ReservationStatus status;

	private Timestamp date;

	private BigDecimal prepayment;

	@ManyToOne
	@JoinColumn(name="ExpeditionID")
	private Expedition expedition;

	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	@OneToMany(mappedBy="reservation")
	private Set<Complaint> complaints;

	private static final long serialVersionUID = 1L;

	public Reservation() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public BigDecimal getPrepayment() {
		return prepayment;
	}

	public void setPrepayment(BigDecimal prepayment) {
		this.prepayment = prepayment;
	}

	public Expedition getExpedition() {
		return expedition;
	}

	public void setExpedition(Expedition expedition) {
		this.expedition = expedition;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}


}
