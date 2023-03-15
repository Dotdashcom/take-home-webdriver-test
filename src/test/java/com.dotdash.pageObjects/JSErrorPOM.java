package com.dotdash.pageObjects;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.dotdash.testUtils.TestBase;

public class JSErrorPOM extends TestBase{

	
	public void userCheckJSError() {

			    Set<String> errorStrings = new HashSet<>();
			    errorStrings.add("SyntaxError");
			    errorStrings.add("EvalError");
			    errorStrings.add("ReferenceError");
			    errorStrings.add("RangeError");
			    errorStrings.add("TypeError");
			    errorStrings.add("URIError");
			    LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
			    for (LogEntry logEntry : logEntries) {
			        for (String errorString : errorStrings) {

			            if (logEntry.getMessage().contains(errorString)) {
				        	System.out.println(logEntry.getMessage());
				        	boolean flag=(logEntry.getMessage()).contains(prop.getProperty("JSErrorMsg"));
				        	System.out.println(flag);
			            }
			           //     LOGGER.error("Java Script error has been detected:");
			         //       LOGGER.error(new Date(logEntry.getTimestamp()) + " " + logEntry.getLevel() + " " + logEntry.getMessage());
			           //     return true;
			           // }
			        }
			    }
			 //   return false;
			}
	}

