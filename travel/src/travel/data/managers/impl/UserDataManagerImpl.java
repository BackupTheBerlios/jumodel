package travel.data.managers.impl;

import java.util.List;

import org.springframework.dao.support.DataAccessUtils;

import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.User;
import travel.data.managers.UserDataManager;
import travel.data.managers.common.CommonManager;

public class UserDataManagerImpl extends CommonManager implements UserDataManager {
		
	@Override
	public List<Quarter> getKwatery() {
		return getSqlMapTemplate().queryForList("getKwatery");
	}

	@Override
	public User getUserByLogin(String login) {
		String hql="from User where login=:login";
		List<User> userList=getHibernateTemplate().findByNamedParam(hql, "login", login);
		return (User) DataAccessUtils.uniqueResult(userList); 
	}



	@Override
	public List<User> findUserByExample(User user) {
		return getHibernateTemplate().findByExample(user);
	}

	@Override
	public void save(User db) {
		getHibernateTemplate().save(db);
	}

}
