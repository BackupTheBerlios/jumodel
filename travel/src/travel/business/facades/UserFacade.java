package travel.business.facades;

import java.util.List;

import travel.data.entities.jpa.Quarter;

public interface UserFacade {
	boolean authenticate(String user, String pass);

	List<Quarter> getKwatery();
}
