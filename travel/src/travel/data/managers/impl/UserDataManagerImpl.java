package travel.data.managers.impl;

import java.util.List;

import travel.data.entities.jpa.Quarter;
import travel.data.managers.UserDataManager;
import travel.data.managers.common.CommonManager;

public class UserDataManagerImpl extends CommonManager implements UserDataManager {

	@Override
	public boolean authenticate(String user, String pass) {
		System.out.println("fdsfafa");
		logger.info("Uwaga bede cos robic");
		
		Quarter q=(Quarter) getHibernateTemplate().get(Quarter.class, 1);
		
		//getHibernateTemplate().
		System.out.println(q.getOffers());
		return false;
	}

	@Override
	public List<Quarter> getKwatery() {
		return getSqlMapTemplate().queryForList("getKwatery");
	}
	
}
