package travel.data.entities.jpa;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

@Entity
@Table(schema="travel", name = "Categories")
public class Category implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="CategoryID")
	private Integer id;

	private String description;

	private String name;

	@OneToMany(mappedBy="category")
	private Set<Offer> offers;

	private static final long serialVersionUID = 1L;

	public Category() {
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

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}

}
