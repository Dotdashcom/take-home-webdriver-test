package com.takeHomeTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.takeHomeTest.Utils.ProxyDriver;

public class ContextMenuPage extends Page {

	public ContextMenuPage(WebDriver wd, boolean waitForPageToLoad) {
		super(wd, waitForPageToLoad);

	}

	private By contextBox = By.cssSelector("div#hot-spot");
	
	public void rightClick() {
		((ProxyDriver) wd).contextRightClick(contextBox);   // right click method from proxy wrapper class
	}
	
	public String textFromAlert() {
		return ((ProxyDriver) wd).alertText();         // alert method from proxy wrapper class
	}

}
