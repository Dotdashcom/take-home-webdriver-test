package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlAndLoading {

	WebDriver driver;

	public DynamicControlAndLoading(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(d, this);
	}

}
