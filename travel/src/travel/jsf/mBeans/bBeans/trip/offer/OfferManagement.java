package travel.jsf.mBeans.bBeans.trip.offer;

import java.util.LinkedList;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import travel.business.facades.OfferFacade;
import travel.commons.Constants;
import travel.commons.enums.QuarterLuxury;
import travel.commons.enums.QuarterType;
import travel.commons.enums.TransportType;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Category;
import travel.data.entities.jpa.Offer;
import travel.data.entities.jpa.Promotion;
import travel.jsf.converters.auxiliary.DefaultSelectItem;
import travel.jsf.mBeans.bBeans.trip.offer.editor.OfferEditForm;
import travel.jsf.mBeans.commons.BaseBean;

public class OfferManagement extends BaseBean {
	private OfferFacade offerFacade;
	private OfferCriteria criteria=new OfferCriteria();
	private List<Offer> filteredOffersList;
	private List<SelectItem> categories;
	private List<SelectItem> promotions;
	private List<SelectItem> transportTypes;
	private List<SelectItem> quarterTypes;
	private List<SelectItem> quarterLuxuries;
	private Integer amountItems;
	private Integer chosenId;
	private OfferEditForm editForm; 


	public void fillTable(ActionEvent e) {
		filteredOffersList=offerFacade.findOffersByCriteria(criteria);
		amountItems=filteredOffersList.size();
	}

	public void removeRecord(ActionEvent e) {
		logger.info("Removing offer record of id: {}", chosenId);
		offerFacade.removeOfferById(chosenId);
	}
	
	public String go2NewForm() {
		editForm=new OfferEditForm(this);
		editForm.setModType(ModyficationType.INSERT);
		return Constants.NEW_RECORD;
	}

	public String go2EditForm() {
		editForm=new OfferEditForm(this);
		editForm.setModType(ModyficationType.UPDATE);
		for (Offer t : filteredOffersList) {
			if (t.getId().equals(chosenId)) {
				editForm.entry=t;
				break;
			}
		}
		return Constants.EDIT_RECORD;
	}

	
	public List<SelectItem> getCategories() {
		if (categories==null) { //maybe remove it?
			categories=new LinkedList<SelectItem>();
			categories.add(new DefaultSelectItem());
			List<Category> categoryList=offerFacade.findAllCategories();
			
			for (Category category : categoryList) {
				categories.add(new SelectItem(category.getId(), category.getName()));
			}
		}
		return categories;
	}
	
	
	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}
	
	public List<SelectItem> getPromotions() {
		if (promotions==null) { //maybe remove it?
			promotions=new LinkedList<SelectItem>();
			promotions.add(new DefaultSelectItem());
			List<Promotion> promotionList=offerFacade.findAllPromotions();
			
			for (Promotion promotion : promotionList) {
				promotions.add(new SelectItem(promotion.getId(), promotion.getPercentValue()+"% "+promotion.getName()));
			}
		}
		return promotions;
	}
	
	public void setPromotions(List<SelectItem> promotions) {
		this.promotions = promotions;
	}
	
	public List<SelectItem> getTransportTypes() {
		if (transportTypes==null) {
			transportTypes=new LinkedList<SelectItem>();
			transportTypes.add(new DefaultSelectItem());
			for (TransportType transportType : TransportType.values()) {
				transportTypes.add(new SelectItem(transportType, transportType.getViewName()));
			}
		}
		return transportTypes;
	}
	public void setTransportTypes(List<SelectItem> transportTypes) {
		this.transportTypes = transportTypes;
	}
	public List<SelectItem> getQuarterTypes() {
		if (quarterTypes==null) {
			quarterTypes=new LinkedList<SelectItem>();
			quarterTypes.add(new DefaultSelectItem());
			for (QuarterType quarterType : QuarterType.values()) {
				quarterTypes.add(new SelectItem(quarterType, quarterType.getViewName()));
			}
		}
		return quarterTypes;
	}
	public void setQuarterTypes(List<SelectItem> quarterTypes) {
		this.quarterTypes = quarterTypes;
	}
	public List<SelectItem> getQuarterLuxuries() {
		if (quarterLuxuries==null) {
			quarterLuxuries=new LinkedList<SelectItem>();
			quarterLuxuries.add(new DefaultSelectItem());
			for (QuarterLuxury quarterLuxury : QuarterLuxury.values()) {
				quarterLuxuries.add(new SelectItem(quarterLuxury, quarterLuxury.getViewName()));
			}
		}
		return quarterLuxuries;
	}
	public void setQuarterLuxuries(List<SelectItem> quarterLuxuries) {
		this.quarterLuxuries = quarterLuxuries;
	}
	
	
	public OfferFacade getOfferFacade() {
		return offerFacade;
	}

	public void setOfferFacade(OfferFacade offerFacade) {
		this.offerFacade = offerFacade;
	}

	public OfferCriteria getCriteria() {
		return criteria;
	}

	public void setCriteria(OfferCriteria criteria) {
		this.criteria = criteria;
	}

	public List<Offer> getFilteredOffersList() {
		return filteredOffersList;
	}

	public void setFilteredOffersList(List<Offer> filteredOffersList) {
		this.filteredOffersList = filteredOffersList;
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

	public OfferEditForm getEditForm() {
		return editForm;
	}

	public void setEditForm(OfferEditForm editForm) {
		this.editForm = editForm;
	}


}
