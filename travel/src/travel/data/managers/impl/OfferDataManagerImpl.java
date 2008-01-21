package travel.data.managers.impl;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Category;
import travel.data.entities.jpa.Offer;
import travel.data.entities.jpa.Promotion;
import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.Transport;
import travel.data.entities.jpa.Travel;
import travel.data.managers.OfferDataManager;
import travel.data.managers.common.CommonManager;
import travel.jsf.mBeans.bBeans.trip.offer.OfferCriteria;
import travel.jsf.mBeans.bBeans.trip.travel.TravelCriteria;

public class OfferDataManagerImpl extends CommonManager implements OfferDataManager {

	@Override
	public List<Offer> findOffersByCriteria(OfferCriteria crit) {
		logger.info("Searching offers by Criteria:");
		DetachedCriteria criteria=DetachedCriteria.forClass(Offer.class);
		
		Offer exampleOffer=new Offer();
		Quarter exampleQuarter=new Quarter();
		Transport exampleTransport=new Transport();
		Travel exampleTravel=new Travel();
		
		exampleOffer.setName("".equals(crit.getName()) ? null : "%" + crit.getName() + "%");
		exampleQuarter.setLuxury(crit.getQuarterLuxury());
		exampleQuarter.setType(crit.getQuarterType());
		exampleTransport.setType(crit.getTransportType());
		exampleTravel.setCountry("".equals(crit.getCountry()) ? null : "%" + crit.getCountry() + "%");
		
		Example example=Example.create(exampleOffer);
		example.enableLike();
		
		Example travelExample=Example.create(exampleTravel);
		travelExample.enableLike();
		
		criteria.add(example);
		if (crit.getCategory()!=null)
			criteria.add(Restrictions.eq("category.id", crit.getCategory()));
		if (crit.getPromotion()!=null) {
			DetachedCriteria offerPromotionCrit=criteria.createCriteria("offerPromotions");
			offerPromotionCrit.add(Restrictions.eq("promotion.id", crit.getPromotion()));
		}
		
		DetachedCriteria quartCrit=criteria.createCriteria("quarter");
		quartCrit.add(Example.create(exampleQuarter));
		DetachedCriteria transCrit=criteria.createCriteria("transport");
		transCrit.add(Example.create(exampleTransport));
		DetachedCriteria travelCrit=criteria.createCriteria("travel");
		travelCrit.add(travelExample);
		
		//criteria.setProjection(Projections.)
		criteria.setFetchMode("offerPromotions", FetchMode.JOIN);
		//criteria.setFetchMode("expeditions", FetchMode.JOIN);
		
		
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public void removeOfferById(Integer id) {
		Offer tr=(Offer) getHibernateTemplate().get(Offer.class, id);
		getHibernateTemplate().delete(tr);
		logger.info("Object of id: "+id+" was removed");
	}

	@Override
	public List<Category> findAllCategories() {
		return getHibernateTemplate().find("from Category");
	}

	@Override
	public List<Promotion> findAllPromotions() {
		return getHibernateTemplate().find("from Promotion");
	}

	@Override
	public List<Travel> findTravelsByCriteria(TravelCriteria crit) {
		logger.info("Searching travels by Criteria:");
		DetachedCriteria criteria=DetachedCriteria.forClass(Travel.class);
		Travel exampleTravel=new Travel();
		
		exampleTravel.setName("".equals(crit.getName()) ? null : "%"+crit.getName()+"%");
		exampleTravel.setCountry("".equals(crit.getCountry()) ? null : "%"+crit.getCountry()+"%");
		exampleTravel.setPlace("".equals(crit.getPlace()) ? null : "%"+crit.getPlace()+"%");
		
		Example example=Example.create(exampleTravel);
		example.enableLike();
		criteria.add(example);
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public void removeTravelById(Integer chosenId) {
		Travel tr=(Travel) getHibernateTemplate().get(Travel.class, chosenId);
		getHibernateTemplate().delete(tr);
		logger.info("Object of id: "+chosenId+" was removed");
		
	}

	@Override
	public void saveOrUpdateTravel(Travel entry, ModyficationType modType) {
		logger.info("Saving (updating) Travel record");
		if (modType==ModyficationType.INSERT){
			getHibernateTemplate().save(entry);
		}
		else getHibernateTemplate().update(entry);
		
	}

	@Override
	public void saveOrUpdateOffer(Offer entry, ModyficationType modType) {
		logger.info("Saving (updating) Offer record");
		if (modType==ModyficationType.INSERT){
			getHibernateTemplate().save(entry);
		}
		else getHibernateTemplate().update(entry);
		
	}

}
