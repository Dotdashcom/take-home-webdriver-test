package stepDefs;

import static org.junit.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;



import io.cucumber.java.en.*;
import utils.Driver;

public class DynamicContent {
	@Given("I am on the Dynacmic Content page")
	public void i_am_on_the_Dynacmic_Content_page() {
		Driver.getDriver().get("http://localhost:7080/dynamic_content");
    	Driver.getDriver().manage().window().maximize();	
	}

	@Then("I varify the content changes on each refresh.")
	public void i_varify_the_content_changes_on_each_refresh() throws InterruptedException {
		Actions action = new Actions(Driver.getDriver());
		
		String  actual= Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
		for (int i = 0; i<4; i++ ) {
		Thread.sleep(2000);
		System.out.println(actual);
		action.moveToElement(Driver.getDriver().findElement(By.xpath("//p/a"))).click().build().perform();
		String refreshedText = Driver.getDriver().findElement(By.xpath("(//div[@class='large-10 columns'])[3]")).getText();
		assertNotEquals(refreshedText, actual);
		System.out.println(refreshedText);
		actual = refreshedText;
		
	}
	}
}
