package travel.jsf.mBeans.bBeans.external.quarter;

import java.util.List;

import javax.faces.component.UIOutput;
import javax.faces.event.ActionEvent;

import org.apache.myfaces.component.html.ext.HtmlOutputText;

import travel.business.facades.ExternalFacade;
import travel.commons.Constants;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.Travel;
import travel.jsf.mBeans.bBeans.external.quarter.Criteria;
import travel.jsf.mBeans.bBeans.external.quarter.EditForm;
import travel.jsf.mBeans.bBeans.trip.offer.OfferManagement;
import travel.jsf.mBeans.commons.BaseBean;
import travel.jsf.mBeans.commons.BeanName;
import travel.jsf.uitls.FacesUtils;

public class QuarterManagement extends BaseBean {

	private ExternalFacade externalFacade;
	private Criteria criteria=new Criteria();
	private List<Quarter> filteredQuarterList;
	private Integer amountItems;
	private Integer chosenId;
	private EditForm editForm; 
	private String sourceSite;
	private UIOutput uiTitle=new HtmlOutputText();


	public UIOutput getUiTitle() {
		if (sourceSite==null) {
			uiTitle.setValue("Zarządzanie Kwaterami");
		} else {
			uiTitle.setValue("Wybierz kwaterę:");
		}
		return uiTitle;
	}

	public void setUiTitle(UIOutput uiTitle) {
		this.uiTitle = uiTitle;
	}

	public List<Quarter> getFilteredQuarterList() {
		return filteredQuarterList;
	}

	public void setFilteredQuarterList(List<Quarter> filteredQuarterList) {
		this.filteredQuarterList = filteredQuarterList;
	}

	public void fillTable(ActionEvent e) {
		filteredQuarterList=externalFacade.findQuartersByCriteria(criteria);
		amountItems=filteredQuarterList.size();
	}

	public void removeRecord(ActionEvent e) {
		logger.info("Removing quarter record of id: {}", chosenId);
		externalFacade.removeQuarterById(chosenId);
	}
	
	public String go2NewForm() {
		editForm=new EditForm(this);
		editForm.setModType(ModyficationType.INSERT);
		return Constants.NEW_RECORD;
	}

	public String go2EditForm() {
		editForm=new EditForm(this);
		editForm.setModType(ModyficationType.UPDATE);
		for (Quarter t : filteredQuarterList) {
			if (t.getId().equals(chosenId)) {
				editForm.entry=t;
				break;
			}
		}
		return Constants.EDIT_RECORD;
	}
	
	public String selectQuarter() {
		sourceSite=FacesUtils.getRequestParameter("source");
		return "SELECT_QUARTER";
	}
	
	public String go2SourceSite() {
		//Brzydko, ale co zrobić...
		//beforePhase jest dopiero w wersji 1.2, moze w 2.0 bedzie w koncu obsługa GET
		if (sourceSite.equals(BeanName.OFFER_MANAGEMENT)) {
			OfferManagement offerm=(OfferManagement) FacesUtils.getManagedBean(BeanName.OFFER_MANAGEMENT);
			offerm.getEditForm().getEntry().getQuarter().setId(chosenId);
			String name=null;
			for (Quarter quarter : filteredQuarterList) {
				if (quarter.getId().equals(chosenId)) {
					name=quarter.getName();
					break;
				}
			}
			offerm.getEditForm().getEntry().getQuarter().setName(name);

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
	
	

	
	
	public EditForm getEditForm() {
		return editForm;
	}

	public void setEditForm(EditForm editForm) {
		this.editForm = editForm;
	}
	
	public QuarterManagement() {
		// TODO Auto-generated constructor stub
	}

	public String getSourceSite() {
		return sourceSite;
	}

	public void setSourceSite(String sourceSite) {
		this.sourceSite = sourceSite;
	}

}
