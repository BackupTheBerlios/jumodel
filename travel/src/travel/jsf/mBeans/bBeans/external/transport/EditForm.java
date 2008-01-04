package travel.jsf.mBeans.bBeans.external.transport;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Transport;

public class EditForm {
	public Transport entry;

	private ModyficationType modType;
	
	
	public EditForm() {
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
