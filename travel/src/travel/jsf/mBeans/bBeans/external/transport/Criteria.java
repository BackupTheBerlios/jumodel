package travel.jsf.mBeans.bBeans.external.transport;

import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import travel.commons.enums.TransportType;
import travel.jsf.converters.auxiliary.DefaultSelectItem;

public class Criteria {
	private String company;
	private TransportType chosenType;
	private List<SelectItem> types;
	private Integer amountPlaces;
	
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public TransportType getChosenType() {
		return chosenType;
	}
	public void setChosenType(TransportType chosenType) {
		this.chosenType = chosenType;
	}
	public List<SelectItem> getTypes() {
		if (types==null) {
			types=new LinkedList<SelectItem>();
			types.add(new DefaultSelectItem());
			for (TransportType transportType : TransportType.values()) {
				types.add(new SelectItem(transportType, transportType.getViewName()));
			}
		}
		return types;
	}
	public void setTypes(List<SelectItem> types) {
		this.types = types;
	}
	public Integer getAmountPlaces() {
		return amountPlaces;
	}
	public void setAmountPlaces(Integer amountPlaces) {
		this.amountPlaces = amountPlaces;
	}
}
