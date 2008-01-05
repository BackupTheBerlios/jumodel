package travel.business.facades.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import travel.business.facades.ExternalFacade;
import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.Transport;
import travel.data.managers.ExternalDataManager;
import travel.jsf.mBeans.bBeans.external.transport.Criteria;

@Transactional
public class ExternalFacadeImpl implements ExternalFacade {
	private ExternalDataManager dataManager;

	public ExternalDataManager getDataManager() {
		return dataManager;
	}

	public void setDataManager(ExternalDataManager dataManager) {
		this.dataManager = dataManager;
	}

	@Override
	public List<Quarter> getQuarterList() {
		
		System.out.println("fdsfs");
		List<Quarter> result=dataManager.getQuarters();
		System.out.println(result.get(0).getOffers());
		return result;
	}

	@Override
	public List<Transport> findTransportsByCriteria(Criteria criteria) {
		return dataManager.findTransportsByCriteria(criteria);
	}

	@Override
	public void removeTransportById(Integer chosenId) {
		dataManager.removeTransportById(chosenId);
	}

	@Override
	public void saveOrUpdate(Transport entry, ModyficationType modType) {
		dataManager.saveOrUpdate(entry,modType);
		// TODO Auto-generated method stub
		
	}
}
      