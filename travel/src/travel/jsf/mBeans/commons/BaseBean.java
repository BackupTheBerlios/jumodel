package travel.jsf.mBeans.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import travel.jsf.mBeans.main.User;
import travel.jsf.uitls.FacesUtils;

public abstract class BaseBean {
	private User mbUser;
	protected final Logger logger=LoggerFactory.getLogger(getClass());
	protected User getMbUser() {
		if (mbUser==null) { 
			mbUser=(User) FacesUtils.getManagedBean(BeanName.USER);
		}
		return mbUser;
	}
}
