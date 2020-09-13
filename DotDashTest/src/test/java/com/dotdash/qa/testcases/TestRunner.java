package com.dotdash.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestRunner {
	private static TestNG testNg;

	public static void main(String[] args) {
		
		testNg = new TestNG();
		List<String> testNames = new ArrayList();
		
		/*
		 * testNames.add("LoginPageTest.class"); testNames.add("CheckBoxTest.class");
		 * testNames.add("ContextMenuPageTest.class");
		 */
		
		testNg.setTestClasses(new Class[] {LoginPageTest.class,CheckBoxTest.class,ContextMenuPageTest.class,
				DragAndDropPageTest.class,DropDownPageTest.class,DynamaicLoadingPageTest.class,DynamicContentPageTest.class,
				DynamicControlsPageTest.class,FileDownloadPageTest.class,FileUploadPageTest.class,FloatingMenuPageTest.class,
				JavaScriptAlertPageTest.class,MouseHoverPageTest.class});
		testNg.run();
		
		

	}

}
