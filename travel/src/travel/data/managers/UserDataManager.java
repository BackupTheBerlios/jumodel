package travel.data.managers;

import java.util.List;

import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.User;


public interface UserDataManager {
	//User getUserById(Integer i); zle - to nie dao

	List<Quarter> getKwatery();

	User getUserByLogin(String login);
	
	List<User> findUserByExample(User user);

	void save(User db);

}
