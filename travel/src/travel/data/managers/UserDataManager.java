package travel.data.managers;

import java.util.List;

import travel.data.entities.jpa.Quarter;


public interface UserDataManager {
	//User getUserById(Integer i); zle - to nie dao

	boolean authenticate(String user, String pass);

	List<Quarter> getKwatery();
}
