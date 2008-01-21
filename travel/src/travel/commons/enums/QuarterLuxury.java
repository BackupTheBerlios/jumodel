package travel.commons.enums;

public enum QuarterLuxury {
	ENOUGH ("Spoko"), 
	NORMAL ("Normalny"), 
	GOOD ("Dobry"), 
	VERY_GOOD ("Bardzo dobry"), 
	EXCELLENT ("Wyborny"), 
	LUXURIOUS ("Luksusowy");

	private final String viewName;
	
	QuarterLuxury(String viewName){
		this.viewName=viewName;
	};
	
	@Override
	public String toString() {
		return viewName;
	}

	public String getViewName() {
		return viewName;
	}
	
}
