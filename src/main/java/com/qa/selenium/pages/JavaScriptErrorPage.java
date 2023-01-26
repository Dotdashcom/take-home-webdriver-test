package com.qa.selenium.pages;

import java.util.Set;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;

import com.qa.selenium.base.TestBase;

public class JavaScriptErrorPage extends TestBase {

	public String Msg;

	public JavaScriptErrorPage() {
		PageFactory.initElements(driver, this);
	}

	public String logError() {
		Set<String> log = driver.manage().logs().getAvailableLogTypes();
		for (String a : log) {
		//	System.out.println("This is a "+a);
		}  

		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		// System.out.println("***This is LogType Text***"+ logEntries);

		 for (LogEntry a : logEntries) {

			if (a.getMessage().substring(64).contains(prop.getProperty("JSError"))) {
				
				  this.Msg = a.getMessage().toString().substring(64);
			}}
		 
		 return this.Msg;

		

	}

}
