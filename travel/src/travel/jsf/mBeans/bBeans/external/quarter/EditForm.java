package travel.jsf.mBeans.bBeans.external.quarter;

import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import travel.commons.enums.QuarterLuxury;
import travel.commons.enums.QuarterType;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Quarter;
import travel.jsf.uitls.FacesUtils;

public class EditForm {
	public Quarter entry;
	private ModyficationType modType;
	private QuarterManagement parent;
	private List<SelectItem> quarterTypes;
	private List<SelectItem> quarterLuxuries;

	public List<SelectItem> getQuarterLuxuries() {
		if (quarterLuxuries==null) {
			quarterLuxuries=new LinkedList<SelectItem>();
			
			for (QuarterLuxury quarterLuxury : QuarterLuxury.values()) {
				quarterLuxuries.add(new SelectItem(quarterLuxury, quarterLuxury.getViewName()));
			}
		}
		return quarterLuxuries;
	}

	public void setQuarterLuxuries(List<SelectItem> quarterLuxuries) {
		this.quarterLuxuries = quarterLuxuries;
	}

	public void saveQuarter(ActionEvent e){
		parent.getExternalFacade().saveOrUpdate(entry,modType);
		parent.fillTable(null); //refreshing parent list
		
		entry=new Quarter();
		FacesUtils.addInfoMessage("Zmiany zostały zapisane pomyślnie.");
		
	}

	public List<SelectItem> getQuarterTypes() {
		if (quarterTypes==null) {
			quarterTypes=new LinkedList<SelectItem>();
			
			for (QuarterType quarterType : QuarterType.values()) {
				quarterTypes.add(new SelectItem(quarterType, quarterType.getViewName()));
			}
		}
		return quarterTypes;
		
	}

	public void setQuarterTypes(List<SelectItem> quarterTypes) {
		this.quarterTypes = quarterTypes;
	}


	public EditForm(QuarterManagement parent) {
		this.parent=parent;
		entry=new Quarter();
	}

	public Quarter getEntry() {
		return entry;
	}

	public void setEntry(Quarter entry) {
		this.entry = entry;
	}

	public ModyficationType getModType() {
		return modType;
	}

	public void setModType(ModyficationType modType) {
		this.modType = modType;
	}

	
}
