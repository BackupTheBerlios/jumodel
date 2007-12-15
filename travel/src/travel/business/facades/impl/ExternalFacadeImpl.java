package travel.business.facades.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import travel.business.facades.ExternalFacade;
import travel.data.entities.jpa.Quarter;
import travel.data.managers.ExternalDataManager;

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
}
