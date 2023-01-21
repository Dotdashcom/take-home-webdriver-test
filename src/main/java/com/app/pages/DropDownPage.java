package com.app.pages;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.app.util.PageLinks;

public class DropDownPage extends BasePage{

	public DropDownPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(id = "dropdown")
	private WebElement dropDown;
	
	
	public void visitDropDownPage() {
		getDriver().get(PageLinks.DROP_DOWN_PAGE);
	}
	
	public void verifyDropDown() {
		Select options = new Select(dropDown);
		options.selectByVisibleText("Option 1");
		
		String selectedOption = options.getFirstSelectedOption().getText();
		
		assertEquals("Option 1",selectedOption );
		
		options.selectByVisibleText("Option 2");
		
		selectedOption = options.getFirstSelectedOption().getText();
		
		assertEquals("Option 2",selectedOption );
	}
	public static void main(String[] args) {
		
		Random random = new Random();
		random.nextInt();
		System.out.println( (int ) (Math.random() * (2) + 1));
		
	}
}
