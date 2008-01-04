package travel.jsf.mBeans.bBeans;

import javax.faces.model.SelectItem;

import travel.business.facades.UserFacade;
import travel.commons.Constants;
import travel.commons.enums.Role;
import travel.jsf.mBeans.commons.BaseBean;
import travel.jsf.uitls.FacesUtils;

public class Registration extends BaseBean {
	private String repeatPassword;
	private Role chosenType=Role.CUSTOMER;
	private travel.data.entities.jpa.User dbUser;
	private UserFacade userFacade;
	private boolean registered=false;
	
	private SelectItem [] types = {
		new SelectItem(Role.CUSTOMER, "Klient"),
		new SelectItem(Role.EMPLOYEE, "Pracownik"),
		new SelectItem(Role.MANAGER, "Admin")
	};


	
	public Registration() {
		dbUser=new travel.data.entities.jpa.User();
	}

	public String register() {
		Role role=chosenType;
		
		if (!dbUser.getPassword().equals(repeatPassword)) {
			FacesUtils.addErrorMessage("registerForm:repeatPassword", "Wpisane hasła są niezgodne");
			return Constants.FAILURE;
		} 
		if (userFacade.loginExists(dbUser.getLogin())) {
			FacesUtils.addErrorMessage("registerForm:login", "Podany login już istnieje.");
			return Constants.FAILURE;
		}
		
		dbUser.setRole(role);
		userFacade.persist(dbUser);
		
		if (role==Role.CUSTOMER)
			FacesUtils.addInfoMessage("Gratulacje.<br>Zostałeś zarejestrowany pomyślnie.");
		else {
			FacesUtils.addInfoMessage("Użytkownik został zarejestrowany pomyślnie.");
		}
		dbUser=new travel.data.entities.jpa.User();
		registered=true;
		return Constants.SUCCESS;
	}
	
	
	
	
	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	public Role getChosenType() {
		return chosenType;
	}

	public void setChosenType(Role chosenType) {
		this.chosenType = chosenType;
	}

	public SelectItem[] getTypes() {
		return types;
	}

	public void setTypes(SelectItem[] types) {
		this.types = types;
	}

	public travel.data.entities.jpa.User getDbUser() {
		return dbUser;
	}

	public void setDbUser(travel.data.entities.jpa.User dbUser) {
		this.dbUser = dbUser;
	}

	public UserFacade getUserFacade() {
		return userFacade;
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

}
