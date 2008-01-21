package travel.commons.enums;

public enum QuarterType {
	HOTEL("Hotel"),
	MOTEL("Motel"),
	CAMP_SITE("Pole namiotowe"),
	CARAVAN_SITE("Kemping"),
	OTHER("Inne");
	
	private final String viewName;
	
	QuarterType(String viewName) {
		this.viewName=viewName;
	}

	public String getViewName() {
		return viewName;
	}
	
	@Override
	public String toString() {
		return viewName;
	}
}
