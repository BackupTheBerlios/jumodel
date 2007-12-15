package travel.business.facades.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import travel.business.facades.UserFacade;
import travel.data.entities.jpa.Quarter;
import travel.data.managers.UserDataManager;

// @Service("userFacade")
@Transactional
public class UserFacadeImpl implements UserFacade {
	//@Autowired
	private UserDataManager dataManager;
	
	

	@Override
	public boolean authenticate(String user, String pass) {
		return dataManager.authenticate(user, pass);
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
}
