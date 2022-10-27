package com.takeHomeTest.Browser;

import com.takeHomeTest.Browser.Browser;

public enum Browser {

	EDGE("MicrosoftEdge"), 
	GOOGLE_CHROME("Chrome"), 
	FIREFOX("Firefox");

	private String name;

	Browser(String name) {
		this.name = name;
	}
	
	public String getBrowsername() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
		
	}
	
	public static Browser getByName(String name) {

		Browser returnvalue=null;
		for(final Browser element: Browser.values()) {
		if(element.toString().equals(name)) {
			
			returnvalue=element;
		}	
		}
		return returnvalue;
		}
}
