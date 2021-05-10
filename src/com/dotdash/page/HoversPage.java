package com.dotdash.page;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage extends AbstractPage {
	public static final String RELATIVE_PATH = "/hovers";
	private List<WebElement> figures;
	private List<WebElement> captions;

	public HoversPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public void verifyPage() {
		verifyPage(new boolean[] {false, false, false});
	}
	
	public void verifyPage(boolean[] captionVisible) {
		figures = driver.findElements(By.className("figure"));
		assertEquals(figures.size(), 3);
		for (WebElement figure : figures) {
			assertTrue(figure.isDisplayed());
		}

		captions = driver.findElements(By.className("figcaption"));
		assertEquals(captions.size(), 3);
		for (int i = 0; i < captions.size(); i++) {
			assertEquals(captions.get(i).isDisplayed(), captionVisible[i]);
		}
	}

	public void hoverOnFigure(int figureIndex) {
		WebElement figure = figures.get(figureIndex);
		new Actions(driver).moveToElement(figure).perform();
	}	
}
