package travel.jsf.mBeans.bBeans.trip.travel;

import java.util.List;

import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.myfaces.component.html.ext.HtmlOutputText;

import travel.business.facades.OfferFacade;
import travel.commons.Constants;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Travel;
import travel.jsf.mBeans.bBeans.trip.offer.OfferManagement;
import travel.jsf.mBeans.commons.BaseBean;
import travel.jsf.mBeans.commons.BeanName;
import travel.jsf.uitls.FacesUtils;

public class TravelManagement extends BaseBean {
	private OfferFacade offerFacade;
	private TravelCriteria criteria=new TravelCriteria();
	private List<Travel> filteredTravelsList;
	private Integer amountItems;
	private Integer chosenId;
	private TravelEditForm editForm;
	private String sourceSite;
	private UIOutput uiTitle=new HtmlOutputText();

	
	public UIOutput getUiTitle() {
		if (sourceSite==null) {
			uiTitle.setValue("Zarządzanie Wycieczkami");
		} else {
			uiTitle.setValue("Wybierz wycieczkę:");
		}
		return uiTitle;
	}

	public void setUiTitle(UIOutput uiTitle) {
		this.uiTitle = uiTitle;
	}

	public TravelEditForm getEditForm() {
		return editForm;
	}

	public void setEditForm(TravelEditForm editForm) {
		this.editForm = editForm;
	}

	public void fillTable(ActionEvent e) {
		filteredTravelsList=offerFacade.findTravelsByCriteria(criteria);
		amountItems=filteredTravelsList.size();
	}

	public void removeRecord(ActionEvent e) {
		logger.info("Removing travel record of id: {}", chosenId);
		offerFacade.removeTravelById(chosenId);
	}
	
	public String go2NewForm() {
		editForm=new TravelEditForm(this);
		editForm.setModType(ModyficationType.INSERT);
		return Constants.NEW_RECORD;
	}

	public String go2EditForm() {
		editForm=new TravelEditForm(this);
		editForm.setModType(ModyficationType.UPDATE);
		for (Travel t : filteredTravelsList) {
			if (t.getId().equals(chosenId)) {
				editForm.entry=t;
				break;
			}
		}
		return Constants.EDIT_RECORD;
	}

	
	public String selectTravel() {
		sourceSite=FacesUtils.getRequestParameter("source");
		/*UIOutput outputTitle=(UIOutput) FacesContext.getCurrentInstance().getViewRoot().findComponent("title");
		outputTitle.setValue("Wybór wycieczki");*/
		return "SELECT_TRAVEL";
	}
	
	public String go2SourceSite() {
		//Brzydko, ale co zrobić...
		//beforePhase jest dopiero w wersji 1.2, moze w 2.0 bedzie w koncu obsługa GET
		if (sourceSite.equals(BeanName.OFFER_MANAGEMENT)) {
			OfferManagement offerm=(OfferManagement) FacesUtils.getManagedBean(BeanName.OFFER_MANAGEMENT);
			offerm.getEditForm().getEntry().getTravel().setId(chosenId);
			String name=null;
			for (Travel travel : filteredTravelsList) {
				if (travel.getId().equals(chosenId)) {
					name=travel.getName();
					break;
				}
			}
			offerm.getEditForm().getEntry().getTravel().setName(name);

		}	
		
		return Constants.ASSIGN_TARGET+sourceSite.toUpperCase();
	}
	public OfferFacade getOfferFacade() {
		return offerFacade;
	}

	public void setOfferFacade(OfferFacade offerFacade) {
		this.offerFacade = offerFacade;
	}

	public TravelCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(TravelCriteria criteria) {
		this.criteria = criteria;
	}

	public List<Travel> getFilteredTravelsList() {
		return filteredTravelsList;
	}

	public void setFilteredTravelsList(List<Travel> filteredTravelsList) {
		this.filteredTravelsList = filteredTravelsList;
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

	public String getSourceSite() {
		return sourceSite;
	}

	public void setSourceSite(String sourceSite) {
		this.sourceSite = sourceSite;
	}

	
}
