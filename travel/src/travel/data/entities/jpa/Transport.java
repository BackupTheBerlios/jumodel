package travel.data.entities.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import travel.commons.enums.TransportType;

import static javax.persistence.EnumType.STRING;

@Entity
@Table(schema="travel", name="Transports")
public class Transport implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="TransportID")
	private Integer id;

	private int AmountOfPlaces;

	private String description;

	private String company;

	@Enumerated(STRING)
	private TransportType type;

	@OneToMany(mappedBy="transport")
	private Set<Offer> offers;

	private static final long serialVersionUID = 1L;

	public Transport() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAmountOfPlaces() {
		return AmountOfPlaces;
	}

	public void setAmountOfPlaces(int amountOfPlaces) {
		AmountOfPlaces = amountOfPlaces;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	public TransportType getType() {
		return type;
	}

	public void setType(TransportType type) {
		this.type = type;
	}


}
