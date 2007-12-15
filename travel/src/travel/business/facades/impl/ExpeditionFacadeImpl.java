package travel.business.facades.impl;

import org.springframework.transaction.annotation.Transactional;

import travel.data.managers.ExpeditionDataManager;

@Transactional
public class ExpeditionFacadeImpl implements
		travel.business.facades.ExpeditionFacade {
	private ExpeditionDataManager dataManager;

	public ExpeditionDataManager getDataManager() {
		return dataManager;
	}

	public void setDataManager(ExpeditionDataManager dataManager) {
		this.dataManager = dataManager;
	}
}
