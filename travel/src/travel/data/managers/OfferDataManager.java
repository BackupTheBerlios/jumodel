package travel.data.managers;

import java.util.List;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Category;
import travel.data.entities.jpa.Offer;
import travel.data.entities.jpa.Promotion;
import travel.data.entities.jpa.Travel;
import travel.jsf.mBeans.bBeans.trip.offer.OfferCriteria;
import travel.jsf.mBeans.bBeans.trip.travel.TravelCriteria;

public interface OfferDataManager {

	List<Offer> findOffersByCriteria(OfferCriteria criteria);

	void removeOfferById(Integer chosenId);

	List<Category> findAllCategories();

	List<Promotion> findAllPromotions();

	List<Travel> findTravelsByCriteria(TravelCriteria criteria);

	void removeTravelById(Integer chosenId);

	void saveOrUpdateTravel(Travel entry, ModyficationType modType);

	void saveOrUpdateOffer(Offer entry, ModyficationType modType);

}
