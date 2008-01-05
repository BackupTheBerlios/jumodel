package travel.jsf.mBeans.bBeans.external.transport;

import java.util.LinkedList;
import java.util.List;

import javax.faces.model.SelectItem;

import travel.business.facades.ExternalFacade;
import travel.commons.Constants;
import travel.commons.enums.TransportType;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Transport;
import travel.jsf.converters.auxiliary.DefaultSelectItem;
import travel.jsf.uitls.FacesUtils;

public class EditForm {
	public Transport entry;
	private TransportType chosenType;
	private ModyficationType modType;
	private ExternalFacade externalFacade;
	public String saveTransport(){
		externalFacade.saveOrUpdate(entry,modType);
		FacesUtils.addInfoMessage("Zastaly  zapisane zminay");
		return Constants.SUCCESS;
		
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

	public TransportType getChosenType() {
		return chosenType;
	}

	public void setChosenType(TransportType chosenType) {
		this.chosenType = chosenType;
	}

	public EditForm(ExternalFacade externalFacade) {
		this.externalFacade=externalFacade;
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
