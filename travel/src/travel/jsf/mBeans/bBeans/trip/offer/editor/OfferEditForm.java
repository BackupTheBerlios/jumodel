package travel.jsf.mBeans.bBeans.trip.offer.editor;

import javax.faces.event.ActionEvent;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Category;
import travel.data.entities.jpa.Offer;
import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.Transport;
import travel.data.entities.jpa.Travel;
import travel.jsf.mBeans.bBeans.trip.offer.OfferManagement;
import travel.jsf.uitls.FacesUtils;


public class OfferEditForm {
	public Offer entry;
	private ModyficationType modType;
	private OfferManagement parent;
	
	
	
	public OfferEditForm(OfferManagement parent) {
		this.parent=parent;
		entry=getEmptyOffer();
	}
	
	private Offer getEmptyOffer() {
		Offer o=new Offer();
		o.setTravel(new Travel());
		o.setQuarter(new Quarter());
		o.setTransport(new Transport());
		o.setCategory(new Category());
		return o;
	}
	
	
	
	public void saveOffer(ActionEvent e){
		parent.getOfferFacade().saveOrUpdateOffer(entry,modType);
		parent.fillTable(null); //refreshing parent list
		
		entry=getEmptyOffer();
		FacesUtils.addInfoMessage("Zmiany zostały zapisane pomyślnie.");
		
	}



	public Offer getEntry() {
		return entry;
	}



	public void setEntry(Offer entry) {
		this.entry = entry;
	}



	public ModyficationType getModType() {
		return modType;
	}



	public void setModType(ModyficationType modType) {
		this.modType = modType;
	}




}
