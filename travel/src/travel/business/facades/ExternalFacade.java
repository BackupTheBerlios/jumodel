package travel.business.facades;

import java.util.List;

import travel.data.entities.jpa.Quarter;

public interface ExternalFacade {

	List<Quarter> getQuarterList();

}
