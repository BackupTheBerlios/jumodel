package travel.commons.enums;

public enum TransportType {
	BUS("Bus"),
	PLANE("Samolot"),
	SHIP("Statek"),
	TRAIN("Pociag"),
	COACH("Autokar"),
	OTHER("inne")
	;
	
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
