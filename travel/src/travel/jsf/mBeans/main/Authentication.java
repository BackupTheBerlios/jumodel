package travel.jsf.mBeans.main;

import java.util.Date;

import javax.faces.application.FacesMessage;

import travel.business.facades.UserFacade;
import travel.data.entities.jpa.User;
import travel.jsf.mBeans.commons.BaseBean;
import travel.jsf.uitls.FacesUtils;

public class Authentication extends BaseBean {
	private String login;
	private String passwd;
	private UserFacade userFacade;
	
	
	/**
	 * It is action method invoked when user is trying to login to the system.
	 * @author rafik
	 * @return 
	 */
	public String login() {
		boolean authenticated=userFacade.authenticate(login, passwd);
		if (authenticated) {
			User user=userFacade.getUserByLogin(login);
			logger.info("Logged User \n" +
						"ID: {} \n" +
						"login: {} \n" +
						"role: {} \n", 
						new Object[] {
							user.getId(), user.getLogin(), user.getRole()}
					);
			passedLoggingUser(user);
			return "AUTHENTICATION_SUCCESS";
		} else {
			failedLoggingUser(login);
			return "AUTHENTICATION_FAILED";
		}
	}
	
	/**
	 * Method making additional procedures when user authenticate failed:<br>
	 * <ul>
	 * <li>add warning message to View about failed logging</li>
	 * <li>...
	 * </ul>
	 * @author rafik
	 * @param login
	 */
	private void failedLoggingUser(String login) {
		FacesUtils.addMessage("Wpisane dane są nieprawidłowe.", FacesMessage.SEVERITY_ERROR);
	}

	/**
	 * Method making additional procedures when user was logged successfully, like:<br>
	 * <ul>
	 * <li>creating object of class Visit</li>
	 * <li>injecting Visit instance and Hibernate User to managed bean User
	 * </ul>
	 * @author rafik
	 * @param user 
	 */
	private void passedLoggingUser(User user) {
		Visit visit=new Visit();
		visit.setLoggingDate(new Date());

		getMbUser().setDb(user);
		getMbUser().setLogged(true);
		getMbUser().setVisit(visit);
		FacesUtils.addMessage("Zostaleś zalogowany pomyslnie.", FacesMessage.SEVERITY_INFO);
	}

	public String logout() {
		getMbUser().setDb(null);
		getMbUser().setLogged(false);
		getMbUser().setVisit(null);
		return "USER_LOGOUT";
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public travel.business.facades.UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(travel.business.facades.UserFacade userFacade) {
		this.userFacade = userFacade;
	}
}
