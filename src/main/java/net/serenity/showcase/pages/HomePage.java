package net.serenity.showcase.pages;

import net.serenity.showcase.utils.Util;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


@DefaultUrl("http://localhost:7080/")
public class HomePage extends GlobalPage {
	
	private static Logger logger = Logger.getLogger(HomePage.class);

	/**
	 * Constructor.
	 */  
    public HomePage(final WebDriver driver) {
    	super(driver, Util.getOrHomePage());
    	logger.log(Level.INFO, Util.getMethodName(0) + " Instantiated");
    }
              
}


