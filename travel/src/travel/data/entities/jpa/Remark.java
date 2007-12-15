package travel.data.entities.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema="travel", name="Remarks")
public class Remark implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="RemarkID")
	private Integer id;
	private String description;
	private String name;

	@ManyToOne
	@JoinColumn(name="ExpeditionID")
	private Expedition expedition;

	private static final long serialVersionUID = 1L;

	public Remark() {
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

	public Expedition getExpedition() {
		return expedition;
	}

	public void setExpedition(Expedition expedition) {
		this.expedition = expedition;
	}

	
}
