package travel.data.entities.jpa;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="travel", name="OfferPromotions")
public class OfferPromotion implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="OfferPromotionsID")
	private Integer id;

	private String description;

	private Timestamp dateTo;

	private Timestamp dateFrom;

	@ManyToOne
	@JoinColumn(name="OfferID")
	private Offer offer;

	@ManyToOne
	@JoinColumn(name="PromotionID")
	private Promotion promotion;

	private static final long serialVersionUID = 1L;

	public OfferPromotion() {
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

	public Timestamp getDateTo() {
		return dateTo;
	}

	public void setDateTo(Timestamp dateTo) {
		this.dateTo = dateTo;
	}

	public Timestamp getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Timestamp dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}



}
