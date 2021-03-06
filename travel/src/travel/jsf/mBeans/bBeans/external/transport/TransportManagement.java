package travel.jsf.mBeans.bBeans.external.transport;

import java.util.List;

import javax.faces.component.UIOutput;
import javax.faces.event.ActionEvent;

import org.apache.myfaces.component.html.ext.HtmlOutputText;

import travel.business.facades.ExternalFacade;
import travel.commons.Constants;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Transport;
import travel.jsf.mBeans.bBeans.trip.offer.OfferManagement;
import travel.jsf.mBeans.commons.BaseBean;
import travel.jsf.mBeans.commons.BeanName;
import travel.jsf.uitls.FacesUtils;

public class TransportManagement extends BaseBean {
	private ExternalFacade externalFacade;
	private Criteria criteria=new Criteria();
	private List<Transport> filteredTransportsList;
	private Integer amountItems;
	private Integer chosenId;
	private EditForm editForm; 
	private String sourceSite;
	private UIOutput uiTitle=new HtmlOutputText();


	public UIOutput getUiTitle() {
		if (sourceSite==null) {
			uiTitle.setValue("Zarządzanie środkami transportu");
		} else {
			uiTitle.setValue("Wybierz transport:");
		}
		return uiTitle;
	}

	public void setUiTitle(UIOutput uiTitle) {
		this.uiTitle = uiTitle;
	}



	public void fillTable(ActionEvent e) {
		filteredTransportsList=externalFacade.findTransportsByCriteria(criteria);
		amountItems=filteredTransportsList.size();
	}

	public void removeRecord(ActionEvent e) {
		logger.info("Removing transport record of id: {}", chosenId);
		externalFacade.removeTransportById(chosenId);
	}
	
	public String go2NewForm() {
		editForm=new EditForm(this);
		editForm.setModType(ModyficationType.INSERT);
		return Constants.NEW_RECORD;
	}

	public String go2EditForm() {
		editForm=new EditForm(this);
		editForm.setModType(ModyficationType.UPDATE);
		for (Transport t : filteredTransportsList) {
			if (t.getId().equals(chosenId)) {
				editForm.entry=t;
				//editForm.setChosenType(t.getType());
				break;
			}
		}
		return Constants.EDIT_RECORD;
	}
	
	public String selectTransport() {
		sourceSite=FacesUtils.getRequestParameter("source");
		return "SELECT_TRANSPORT";
	}
	
	public String go2SourceSite() {
		//Brzydko, ale co zrobić...
		//beforePhase jest dopiero w wersji 1.2, moze w 2.0 bedzie w koncu obsługa GET
		if (sourceSite.equals(BeanName.OFFER_MANAGEMENT)) {
			OfferManagement offerm=(OfferManagement) FacesUtils.getManagedBean(BeanName.OFFER_MANAGEMENT);
			offerm.getEditForm().getEntry().getTransport().setId(chosenId);
			String company=null;
			for (Transport transport : filteredTransportsList) {
				if (transport.getId().equals(chosenId)) {
					company=transport.getCompany();
					break;
				}
			}
			offerm.getEditForm().getEntry().getTransport().setCompany(company);

		}	
		
		return Constants.ASSIGN_TARGET+sourceSite.toUpperCase();
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

	public String getSourceSite() {
		return sourceSite;
	}

	public void setSourceSite(String sourceSite) {
		this.sourceSite = sourceSite;
	}
}
