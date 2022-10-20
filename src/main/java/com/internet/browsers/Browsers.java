package com.internet.browsers;

public enum Browsers {
	EDGE("MicrosoftEdge"), 
	GOOGLE_CHROME("Chrome"), 
	FIREFOX("Firefox");

	private String name;

	Browsers(String name) {
		this.name = name;
	}
	
	public String getBrowsername() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
		
	}
	
	public static Browsers getByName(String name) {

		Browsers returnvalue=null;
		for(final Browsers element: Browsers.values()) {
		if(element.toString().equals(name)) {
			
			returnvalue=element;
		}	
		}
		return returnvalue;
		}
}
