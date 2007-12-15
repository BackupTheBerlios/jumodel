package travel.data.entities.jpa;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import travel.commons.enums.QuarterLuxury;
import travel.commons.enums.QuarterType;

import static javax.persistence.EnumType.STRING;
@NamedQueries({
	@NamedQuery(name="findAllQuarters", query="select q from Quarter q"),
	@NamedQuery(name="findQuarterById", query="select q from Quarter q where q.id=:id")
})
@Entity
@Table(schema="travel", name="Quarters")
public class Quarter implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="QuarterID")
	private Integer id;

	private String name;

	@Enumerated(STRING)
	private QuarterType type;
	
	@Enumerated(STRING)
	private QuarterLuxury luxury;

	private String description;

	private String address;

	@OneToMany(mappedBy="quarter")
	private Set<Offer> offers;

	private static final long serialVersionUID = 1L;

	public Quarter() {
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


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

	public QuarterType getType() {
		return type;
	}

	public void setType(QuarterType type) {
		this.type = type;
	}

	public QuarterLuxury getLuxury() {
		return luxury;
	}

	public void setLuxury(QuarterLuxury luxury) {
		this.luxury = luxury;
	}

	
}
