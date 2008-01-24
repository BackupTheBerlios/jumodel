package travel.jsf.mBeans.bBeans.trip.expedition.editor;

import javax.faces.event.ActionEvent;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Category;
import travel.data.entities.jpa.Expedition;
import travel.data.entities.jpa.Offer;
import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.Transport;
import travel.data.entities.jpa.Travel;
import travel.jsf.mBeans.bBeans.trip.expedition.ExpeditionManagement;
import travel.jsf.uitls.FacesUtils;


public class ExpeditionEditForm {
	public Expedition entry;
	private ModyficationType modType;
	private ExpeditionManagement parent;
	
	
	
	public ExpeditionEditForm(ExpeditionManagement parent) {
		this.parent=parent;
		entry=getEmptyExpedition();
	}
	
	private Expedition getEmptyExpedition() {
		Expedition e=new Expedition();
		e.setOffer(new Offer());
		return e;
	}
	
	
	
	public void saveExpedition(ActionEvent e){
		parent.getExpeditionFacade().saveOrUpdateExpedition(entry,modType);
		parent.fillTable(null); //refreshing parent list
		
		entry=getEmptyExpedition();
		FacesUtils.addInfoMessage("Zmiany zostały zapisane pomyślnie.");
		
	}



	public Expedition getEntry() {
		return entry;
	}



	public void setEntry(Expedition entry) {
		this.entry = entry;
	}



	public ModyficationType getModType() {
		return modType;
	}



	public void setModType(ModyficationType modType) {
		this.modType = modType;
	}




}
