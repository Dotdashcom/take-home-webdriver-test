package com.QA.testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/",
		glue = "com/QA/testSteps", 
		dryRun = false,
		monochrome = true,
		strict = true,

		tags = "@Login or @CheckBoxes or @ContextMenu or @DragAndDrop"
				+ " or @Dropdown or @DynamicContent or @DynamicControls"
				+ " or @DynamicLoading or @FileDownload or @FileUpload"
				+ " or @FloatingMenu or @Iframe or @MouseHover"
				+ " or @JavaScriptAlerts or @JavaScriptError"
				+ " or @OpenInNewTab or @NotificationMessage",

		plugin = {"pretty", 
				  "html:target/cucumber-default-reports", 				  
				  "json:target/cucumber.json"} 
		)

public class TestRunner {

}