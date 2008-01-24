package travel.data.managers.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Expedition;
import travel.data.entities.jpa.Travel;
import travel.data.managers.ExpeditionDataManager;
import travel.data.managers.common.CommonManager;
import travel.jsf.mBeans.bBeans.trip.expedition.ExpeditionCriteria;

public class ExpeditionDataManagerImpl extends CommonManager implements ExpeditionDataManager {

	@Override
	public List<Expedition> findExpeditionsByCriteria(ExpeditionCriteria crit) {
			logger.info("Searching expeditions by Criteria:");
			DetachedCriteria criteria=DetachedCriteria.forClass(Expedition.class);
			
			Expedition exampleExpedition=new Expedition();
			
			Travel exampleTravel=new Travel();
			
			exampleExpedition.setDateFrom(crit.getDateFrom());
			exampleExpedition.setDateTo(crit.getDateTo());
			exampleTravel.setCountry("".equals(crit.getCountry()) ? null : "%" + crit.getCountry() + "%");
			exampleTravel.setPlace("".equals(crit.getPlace()) ? null : "%" + crit.getPlace() + "%");
			
			
			Example example=Example.create(exampleExpedition);
			example.enableLike();
			
			Example travelExample=Example.create(exampleTravel);
			travelExample.enableLike();
			
			criteria.add(example);

			DetachedCriteria travelCrit=criteria.createCriteria("offer.travel");
			travelCrit.add(travelExample);
			
			//criteria.setProjection(Projections.)
			//criteria.setFetchMode("expeditionPromotions", FetchMode.JOIN);
			//criteria.setFetchMode("expeditions", FetchMode.JOIN);
			
			
			return getHibernateTemplate().findByCriteria(criteria);		
	}

	@Override
	public void removeExpeditionById(Integer chosenId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveOrUpdateExpedition(Expedition entry, ModyficationType modType) {
		// TODO Auto-generated method stub
		
	}

}
