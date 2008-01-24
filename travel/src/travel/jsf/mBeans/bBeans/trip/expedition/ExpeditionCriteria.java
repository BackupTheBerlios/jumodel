package travel.jsf.mBeans.bBeans.trip.expedition;

import java.util.Date;

import travel.data.entities.jpa.Offer;





public class ExpeditionCriteria {
	private String country;
	private Date dateFrom;
	private Date dateTo;
	private String place;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	
	
}
