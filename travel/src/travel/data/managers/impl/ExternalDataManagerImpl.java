package travel.data.managers.impl;

import java.util.List;

import travel.data.entities.jpa.Quarter;
import travel.data.managers.ExternalDataManager;
import travel.data.managers.common.CommonManager;

public class ExternalDataManagerImpl extends CommonManager implements ExternalDataManager{

	@Override
	public List<Quarter> getQuarters() {
		logger.info("Pobieram kwatery");
		return getHibernateTemplate().find("from Quarter");
	}

}
