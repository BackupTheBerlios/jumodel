package travel.jsf.mBeans.bBeans.trip.quarters;

import java.util.List;

import travel.business.facades.ExternalFacade;
import travel.data.entities.jpa.Quarter;

public class QuarterMain {
	private ExternalFacade facade;
	private List<Quarter> fullList;
	

	public List<Quarter> getFullList() {
		if (fullList==null) {
			fullList=facade.getQuarterList();
		}
		return fullList;
	}

	public void setFullList(List<Quarter> fullList) {
		this.fullList = fullList;
	}

	public ExternalFacade getFacade() {
		return facade;
	}

	public void setFacade(ExternalFacade facade) {
		this.facade = facade;
	}
}
