package travel.business.facades.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Category;
import travel.data.entities.jpa.Offer;
import travel.data.entities.jpa.Promotion;
import travel.data.entities.jpa.Travel;
import travel.data.managers.OfferDataManager;
import travel.jsf.mBeans.bBeans.trip.offer.OfferCriteria;
import travel.jsf.mBeans.bBeans.trip.travel.TravelCriteria;

@Transactional
public class OfferFacadeImpl implements travel.business.facades.OfferFacade {
	private OfferDataManager dataManager;

	public OfferDataManager getDataManager() {
		return dataManager;
	}

	public void setDataManager(OfferDataManager dataManager) {
		this.dataManager = dataManager;
	}

	@Override
	public List<Offer> findOffersByCriteria(OfferCriteria criteria) {
		return dataManager.findOffersByCriteria(criteria);
	}

	@Override
	public void removeOfferById(Integer chosenId) {
		dataManager.removeOfferById(chosenId);
	}

	@Override
	public void saveOrUpdateOffer(Offer entry, ModyficationType modType) {
		dataManager.saveOrUpdateOffer(entry, modType);
		
	}

	@Override
	public List<Category> findAllCategories() {
		return dataManager.findAllCategories();
	}

	@Override
	public List<Promotion> findAllPromotions() {
		return dataManager.findAllPromotions();
	}

	@Override
	public List<Travel> findTravelsByCriteria(TravelCriteria criteria) {
		return dataManager.findTravelsByCriteria(criteria);
	}

	@Override
	public void removeTravelById(Integer chosenId) {
		dataManager.removeTravelById(chosenId);
		
	}

	@Override
	public void saveOrUpdateTravel(Travel entry, ModyficationType modType) {
		dataManager.saveOrUpdateTravel(entry,modType);
		
	}
}
