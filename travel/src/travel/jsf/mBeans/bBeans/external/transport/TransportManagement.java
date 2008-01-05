package travel.jsf.mBeans.bBeans.external.transport;

import java.util.List;

import javax.faces.event.ActionEvent;

import travel.business.facades.ExternalFacade;
import travel.commons.Constants;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Transport;
import travel.jsf.mBeans.commons.BaseBean;

public class TransportManagement extends BaseBean {
	private ExternalFacade externalFacade;
	private Criteria criteria=new Criteria();
	private List<Transport> filteredTransportsList;
	private Integer amountItems;
	private Integer chosenId;
	private EditForm editForm; 


	public void fillTable(ActionEvent e) {
		filteredTransportsList=externalFacade.findTransportsByCriteria(criteria);
		amountItems=filteredTransportsList.size();
	}

	public void removeRecord(ActionEvent e) {
		logger.info("Removing transport record of id: {}", chosenId);
		externalFacade.removeTransportById(chosenId);
	}
	
	public String go2NewForm() {
		editForm=new EditForm(externalFacade);
		editForm.setModType(ModyficationType.INSERT);
		return Constants.NEW_RECORD;
	}

	public String go2EditForm() {
		editForm=new EditForm(externalFacade);
		editForm.setModType(ModyficationType.UPDATE);
		for (Transport t : filteredTransportsList) {
			if (t.getId().equals(chosenId)) {
				editForm.entry=t;
				editForm.setChosenType(t.getType());
				break;
			}
		}
		return Constants.EDIT_RECORD;
	}
	
	public Integer getChosenId() {
		return chosenId;
	}

	public void setChosenId(Integer chosenId) {
		this.chosenId = chosenId;
	}

	public Integer getAmountItems() {
		return amountItems;
	}

	public void setAmountItems(Integer amountItems) {
		this.amountItems = amountItems;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public ExternalFacade getExternalFacade() {
		return externalFacade;
	}

	public void setExternalFacade(ExternalFacade externalFacade) {
		this.externalFacade = externalFacade;
	}
	
	
	public List<Transport> getFilteredTransportsList() {
		return filteredTransportsList;
	}

	public void setFilteredTransportsList(List<Transport> filteredTransportsList) {
		this.filteredTransportsList = filteredTransportsList;
	}
	
	public EditForm getEditForm() {
		return editForm;
	}

	public void setEditForm(EditForm editForm) {
		this.editForm = editForm;
	}
}
