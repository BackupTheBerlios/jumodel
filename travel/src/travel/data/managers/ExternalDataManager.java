package travel.data.managers;

import java.util.List;

import travel.data.entities.jpa.Quarter;

public interface ExternalDataManager {

	List<Quarter> getQuarters();

}
