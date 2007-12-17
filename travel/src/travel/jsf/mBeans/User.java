/**
 * 
 */
package travel.jsf.mBeans;

/**
 * @author Administrator
 *
 */
public class User {
	private boolean logged;
	private String role;
	private User oryg;

	public User getOryg() {
		return oryg;
	}

	public void setOryg(User oryg) {
		this.oryg = oryg;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
	}

	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}
}
