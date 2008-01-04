package travel.data.managers;

import java.util.List;

import travel.data.entities.jpa.Quarter;
import travel.data.entities.jpa.Transport;
import travel.jsf.mBeans.bBeans.external.transport.Criteria;

public interface ExternalDataManager {

	List<Quarter> getQuarters();

	List<Transport> findTransportsByCriteria(Criteria criteria);

	void removeTransportById(Integer chosenId);

}
