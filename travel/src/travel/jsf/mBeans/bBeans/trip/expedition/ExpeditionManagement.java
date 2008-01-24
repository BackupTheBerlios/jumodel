package travel.jsf.mBeans.bBeans.trip.expedition;

import java.util.List;

import javax.faces.event.ActionEvent;

import travel.business.facades.ExpeditionFacade;
import travel.commons.Constants;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Expedition;
import travel.jsf.mBeans.bBeans.trip.expedition.editor.ExpeditionEditForm;
import travel.jsf.mBeans.commons.BaseBean;

public class ExpeditionManagement extends BaseBean {
	private ExpeditionFacade expeditionFacade;
	private ExpeditionCriteria criteria=new ExpeditionCriteria();
	private List<Expedition> filteredExpeditionsList;
	private Integer amountItems;
	private Integer chosenId;
	private ExpeditionEditForm editForm; 


	public void fillTable(ActionEvent e) {
		filteredExpeditionsList=expeditionFacade.findExpeditionsByCriteria(criteria);
		amountItems=filteredExpeditionsList.size();
	}

	public void removeRecord(ActionEvent e) {
		logger.info("Removing expedition record of id: {}", chosenId);
		expeditionFacade.removeExpeditionById(chosenId);
	}
	
	public String go2NewForm() {
		editForm=new ExpeditionEditForm(this);
		editForm.setModType(ModyficationType.INSERT);
		return Constants.NEW_RECORD;
	}

	public String go2EditForm() {
		editForm=new ExpeditionEditForm(this);
		editForm.setModType(ModyficationType.UPDATE);
		for (Expedition t : filteredExpeditionsList) {
			if (t.getId().equals(chosenId)) {
				editForm.entry=t;
				break;
			}
		}
		return Constants.EDIT_RECORD;
	}

	public ExpeditionFacade getExpeditionFacade() {
		return expeditionFacade;
	}

	public void setExpeditionFacade(ExpeditionFacade expeditionFacade) {
		this.expeditionFacade = expeditionFacade;
	}

	public ExpeditionCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(ExpeditionCriteria criteria) {
		this.criteria = criteria;
	}

	public List<Expedition> getFilteredExpeditionsList() {
		return filteredExpeditionsList;
	}

	public void setFilteredExpeditionsList(List<Expedition> filteredExpeditionsList) {
		this.filteredExpeditionsList = filteredExpeditionsList;
	}

	public Integer getAmountItems() {
		return amountItems;
	}

	public void setAmountItems(Integer amountItems) {
		this.amountItems = amountItems;
	}

	public Integer getChosenId() {
		return chosenId;
	}

	public void setChosenId(Integer chosenId) {
		this.chosenId = chosenId;
	}

	public ExpeditionEditForm getEditForm() {
		return editForm;
	}

	public void setEditForm(ExpeditionEditForm editForm) {
		this.editForm = editForm;
	}

	
	
	


}
