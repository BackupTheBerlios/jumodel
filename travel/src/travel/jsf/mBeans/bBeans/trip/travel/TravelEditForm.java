package travel.jsf.mBeans.bBeans.trip.travel;

import javax.faces.event.ActionEvent;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Travel;
import travel.jsf.uitls.FacesUtils;

public class TravelEditForm {
	public Travel entry;
	private ModyficationType modType;
	private TravelManagement parent;
	
	public void saveTravel(ActionEvent e){
		parent.getOfferFacade().saveOrUpdateTravel(entry,modType);
		parent.fillTable(null); //refreshing parent list
		
		entry=new Travel();
		FacesUtils.addInfoMessage("Zmiany zostały zapisane pomyślnie.");
		
	}
	
	public TravelEditForm(TravelManagement parent) {
		this.parent=parent;
		entry=new Travel();
	}

	public Travel getEntry() {
		return entry;
	}

	public void setEntry(Travel entry) {
		this.entry = entry;
	}

	public ModyficationType getModType() {
		return modType;
	}

	public void setModType(ModyficationType modType) {
		this.modType = modType;
	}

	
}
