/**
 * 
 */
package travel.jsf.mBeans.main;

import travel.business.facades.UserFacade;
import travel.commons.enums.Role;
import travel.jsf.mBeans.commons.BaseBean;


/**
 * @author rafik
 *
 */
public class User extends BaseBean{
	private boolean logged;
	private UserFacade userFacade;
	private travel.data.entities.jpa.User db;
	private Visit visit;


	public String getRole() {
		if (logged) {
			return db.getRole().name();
		} else {
			return "UNKNOWN";
		}
	}

	public User() {
		db=new travel.data.entities.jpa.User();
	}

	public void setRole(String role) {
		if (!role.equals("UNKNOWN")) {
			db.setRole(Role.valueOf(role));
		}
	}

	
	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public travel.data.entities.jpa.User getDb() {
		return db;
	}

	public void setDb(travel.data.entities.jpa.User db) {
		this.db = db;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

}
