package travel.business.facades.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Expedition;
import travel.data.managers.ExpeditionDataManager;
import travel.jsf.mBeans.bBeans.trip.expedition.ExpeditionCriteria;

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

	@Override
	public List<Expedition> findExpeditionsByCriteria(ExpeditionCriteria criteria) {
		return dataManager.findExpeditionsByCriteria(criteria);
	}

	@Override
	public void removeExpeditionById(Integer chosenId) {
		dataManager.removeExpeditionById(chosenId);		
	}

	@Override
	public void saveOrUpdateExpedition(Expedition entry, ModyficationType modType) {
		dataManager.saveOrUpdateExpedition(entry,modType);
		
	}
}
