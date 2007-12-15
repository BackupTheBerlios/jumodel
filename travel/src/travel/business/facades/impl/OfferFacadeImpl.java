package travel.business.facades.impl;

import org.springframework.transaction.annotation.Transactional;

import travel.data.managers.OfferDataManager;

@Transactional
public class OfferFacadeImpl implements travel.business.facades.OfferFacade {
	private OfferDataManager dataManager;

	public OfferDataManager getDataManager() {
		return dataManager;
	}

	public void setDataManager(OfferDataManager dataManager) {
		this.dataManager = dataManager;
	}
}
