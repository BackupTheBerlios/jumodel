package travel.business.facades.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import travel.business.facades.UserFacade;
import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.User;
import travel.data.managers.UserDataManager;

// @Service("userFacade")
@Transactional
public class UserFacadeImpl implements UserFacade {
	//@Autowired
	public final Logger logger=LoggerFactory.getLogger(UserFacadeImpl.class);
	private UserDataManager dataManager;
	
	

	@Override
	public boolean authenticate(String login, String pass) {
		logger.info("Authentication test for login: {} ...",login.toUpperCase());
		User user=new User();
		user.setLogin(login);
		user.setPassword(pass);
		List result=dataManager.findUserByExample(user);
		
		if (result.isEmpty()) {
			logger.info("Authentication failed.");
			return false; 
		} 
		logger.info("Authentication passed.");
		return true;
	}



	public UserDataManager getDataManager() {
		return dataManager;
	}


	public void setDataManager(UserDataManager dataManager) {
		this.dataManager = dataManager;
	}


	@Override
	public List<Quarter> getKwatery() {
		return dataManager.getKwatery();
	}

	@Override
	public User getUserByLogin(String login) {
		return dataManager.getUserByLogin(login);
	}



	@Override
	public boolean loginExists(String login) {
		return getUserByLogin(login) == null ? false : true;
	}



	@Override
	public void persist(User db) {
		dataManager.save(db);
	}
}
