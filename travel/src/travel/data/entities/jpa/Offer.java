package travel.data.entities.jpa;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(schema="travel", name="Offers")
public class Offer implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="OfferID")
	private Integer id;

	private String description;

	private String name;

	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name="QuarterID")
	private Quarter quarter;

	@ManyToOne
	@JoinColumn(name="CategoryID")
	private Category category;

	@ManyToOne
	@JoinColumn(name="TravelID")
	private Travel travel;

	@ManyToOne
	@JoinColumn(name="TransportID")
	private Transport transport;

	@OneToMany(mappedBy="offer")
	private Set<Expedition> expeditions;

	@OneToMany(mappedBy="offer")
	private Set<OfferPromotion> offerPromotions;

	private static final long serialVersionUID = 1L;

	public Offer() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Quarter getQuarter() {
		return quarter;
	}

	public void setQuarter(Quarter quarter) {
		this.quarter = quarter;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public Set<Expedition> getExpeditions() {
		return expeditions;
	}

	public void setExpeditions(Set<Expedition> expeditions) {
		this.expeditions = expeditions;
	}

	public Set<OfferPromotion> getOfferPromotions() {
		return offerPromotions;
	}

	public void setOfferPromotions(Set<OfferPromotion> offerPromotions) {
		this.offerPromotions = offerPromotions;
	}


}
