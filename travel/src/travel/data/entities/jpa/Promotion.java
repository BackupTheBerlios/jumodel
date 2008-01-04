package travel.data.entities.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema="travel", name="Promotions")
public class Promotion implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="PromotionID")
	private Integer id;

	private String name;

	private Short percentValue;

	private String description;

	@OneToMany(mappedBy="promotion")
	private Set<OfferPromotion> offerPromotions;

	private static final long serialVersionUID = 1L;

	public Promotion() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Short getPercentValue() {
		return percentValue;
	}

	public void setPercentValue(Short percentValue) {
		this.percentValue = percentValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<OfferPromotion> getOfferPromotions() {
		return offerPromotions;
	}

	public void setOfferPromotions(Set<OfferPromotion> offerPromotions) {
		this.offerPromotions = offerPromotions;
	}

	
}
