package travel.jsf.mBeans.bBeans.external.transport;

import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import travel.commons.enums.TransportType;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Transport;
import travel.jsf.uitls.FacesUtils;

public class EditForm {
	public Transport entry;
	private ModyficationType modType;
	private TransportManagement parent;
	
	public void saveTransport(ActionEvent e){
		parent.getExternalFacade().saveOrUpdate(entry,modType);
		parent.fillTable(null); //refreshing parent list
		
		entry=new Transport();
		FacesUtils.addInfoMessage("Zmiany zostały zapisane pomyślnie.");
		
	}
	private List<SelectItem> transportTypes;
	public List<SelectItem> getTransportTypes() {
		if (transportTypes==null) {
			transportTypes=new LinkedList<SelectItem>();
			
			for (TransportType transportType : TransportType.values()) {
				transportTypes.add(new SelectItem(transportType, transportType.getViewName()));
			}
		}
		return transportTypes;
		
	}

	public void setTransportTypes(List<SelectItem> transportTypes) {
		this.transportTypes = transportTypes;
	}


	public EditForm(TransportManagement parent) {
		this.parent=parent;
		entry=new Transport();
	}

	public Transport getEntry() {
		return entry;
	}

	public void setEntry(Transport entry) {
		this.entry = entry;
	}

	public ModyficationType getModType() {
		return modType;
	}

	public void setModType(ModyficationType modType) {
		this.modType = modType;
	}

	
}
