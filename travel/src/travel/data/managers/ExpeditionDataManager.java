package travel.data.managers;

import java.util.List;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Expedition;
import travel.jsf.mBeans.bBeans.trip.expedition.ExpeditionCriteria;

public interface ExpeditionDataManager {

	List<Expedition> findExpeditionsByCriteria(ExpeditionCriteria criteria);

	void removeExpeditionById(Integer chosenId);

	void saveOrUpdateExpedition(Expedition entry, ModyficationType modType);

}
