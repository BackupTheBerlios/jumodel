package travel.data.managers.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.Transport;
import travel.data.managers.ExternalDataManager;
import travel.data.managers.common.CommonManager;
import travel.jsf.mBeans.bBeans.external.transport.Criteria;

public class ExternalDataManagerImpl extends CommonManager implements ExternalDataManager{

	@Override
	public List<Quarter> getQuarters() {
		logger.info("Pobieram kwatery");
		return getHibernateTemplate().find("from Quarter");
	}

	@Override
	public List<Transport> findTransportsByCriteria(Criteria crit) {
		logger.info("Searching transports by Criteria:");
		DetachedCriteria criteria=DetachedCriteria.forClass(Transport.class);
		Transport exampleTrans=new Transport();
		
		exampleTrans.setAmountOfPlaces(crit.getAmountPlaces());
		exampleTrans.setCompany("".equals(crit.getCompany()) ? null : "%"+crit.getCompany()+"%");
		exampleTrans.setType(crit.getChosenType());
		
		Example example=Example.create(exampleTrans);
		example.enableLike();
		criteria.add(example);
		return getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public void removeTransportById(Integer chosenId) {
		Transport tr=(Transport) getHibernateTemplate().get(Transport.class, chosenId);
		getHibernateTemplate().delete(tr);
		logger.info("Object of id: "+chosenId+" was removed");
	}

	@Override
	public void saveOrUpdate(Transport entry, ModyficationType modType) {
		logger.info("Dodawewanie");
		if (modType==ModyficationType.INSERT)
		{
			getHibernateTemplate().save(entry);
		}
		else getHibernateTemplate().update(entry);
		
		
	}

}
