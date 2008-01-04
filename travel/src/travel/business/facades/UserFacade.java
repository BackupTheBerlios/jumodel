package travel.business.facades;

import java.util.List;

import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.User;

public interface UserFacade {
	/**
	 * Method to authenticate user by login and password
	 * 
	 * @author rafik
	 * @param user
	 * @param pass
	 * @return boolean
	 * 
	 */
	boolean authenticate(String user, String pass);

	List<Quarter> getKwatery();

	
	/**
	 * Method to get user by login
	 * @author rafik
	 * @param login
	 * @return User
	 * 
	 */
	User getUserByLogin(String login);

	/**
	 * Tests if login exist in DB now.
	 * @param login
	 * @return 
	 */
	boolean loginExists(String login);

	/**
	 * Method to insert User into DB
	 * @param db
	 */
	void persist(User db);
}
