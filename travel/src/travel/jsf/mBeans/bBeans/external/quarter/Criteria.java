package travel.jsf.mBeans.bBeans.external.quarter;

import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import travel.commons.enums.QuarterLuxury;
import travel.commons.enums.QuarterType;
import travel.commons.enums.TransportType;
import travel.jsf.converters.auxiliary.DefaultSelectItem;

public class Criteria {
	private String name;
	private QuarterType chosenType;
	private QuarterLuxury chosenLuxury;
	private String address;
	private List<SelectItem> types;
	private List<SelectItem> luxuries;	
	
	
	public List<SelectItem> getTypes() {
		if (types==null) {
			types=new LinkedList<SelectItem>();
			types.add(new DefaultSelectItem());
			for (QuarterType quarterType : QuarterType.values()) {
				types.add(new SelectItem(quarterType, quarterType.getViewName()));
			}
		}
		return types;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public QuarterType getChosenType() {
		return chosenType;
	}


	public void setChosenType(QuarterType chosenType) {
		this.chosenType = chosenType;
	}


	public QuarterLuxury getChosenLuxury() {
		return chosenLuxury;
	}


	public void setChosenLuxury(QuarterLuxury chosenLuxury) {
		this.chosenLuxury = chosenLuxury;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<SelectItem> getLuxuries() {
		if (luxuries==null) {
			luxuries=new LinkedList<SelectItem>();
			luxuries.add(new DefaultSelectItem());
			for (QuarterLuxury quarterLuxury : QuarterLuxury.values()) {
				luxuries.add(new SelectItem(quarterLuxury, quarterLuxury.getViewName()));
			}
		}
		return luxuries;
	}


	public void setLuxuries(List<SelectItem> luxuries) {
		this.luxuries = luxuries;
	}


	public void setTypes(List<SelectItem> types) {
		this.types = types;
	}
	
}
