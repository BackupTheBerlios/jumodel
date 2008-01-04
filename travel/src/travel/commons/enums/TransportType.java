package travel.commons.enums;

public enum TransportType {
	MINIBUS("Minibus"),
	BUS("Bus"),
	PLANE("Samolot"),
	SHIP("Statek");
	
	private final String viewName;
	
	TransportType(String viewName) {
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
