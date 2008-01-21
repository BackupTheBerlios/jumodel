package travel.jsf.mBeans.bBeans.trip.offer;

import travel.commons.enums.QuarterLuxury;
import travel.commons.enums.QuarterType;
import travel.commons.enums.TransportType;





public class OfferCriteria {
	private String name;
	private String country;
	private Integer promotion;
	private Integer category;
	private TransportType transportType;
	private QuarterType quarterType;
	private QuarterLuxury quarterLuxury;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPromotion() {
		return promotion;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	
	public TransportType getTransportType() {
		return transportType;
	}
	public void setTransportType(TransportType transportType) {
		this.transportType = transportType;
	}
	public QuarterType getQuarterType() {
		return quarterType;
	}
	public void setQuarterType(QuarterType quarterType) {
		this.quarterType = quarterType;
	}
	public QuarterLuxury getQuarterLuxury() {
		return quarterLuxury;
	}
	public void setQuarterLuxury(QuarterLuxury quarterLuxury) {
		this.quarterLuxury = quarterLuxury;
	}
	public void setPromotion(Integer promotion) {
		this.promotion = promotion;
	}
	
}
