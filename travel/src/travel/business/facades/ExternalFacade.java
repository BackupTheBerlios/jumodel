package travel.business.facades;

import java.util.List;

import travel.commons.enums.others.ModyficationType;
import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.Transport;
import travel.jsf.mBeans.bBeans.external.transport.Criteria;

public interface ExternalFacade {

	List<Transport> findTransportsByCriteria(Criteria criteria);

	void removeTransportById(Integer chosenId);

	void saveOrUpdate(Transport entry, ModyficationType modType);

	void saveOrUpdate(Quarter entry, ModyficationType modType);

	List<Quarter> findQuartersByCriteria(
			travel.jsf.mBeans.bBeans.external.quarter.Criteria criteria);

	void removeQuarterById(Integer chosenId);

}
