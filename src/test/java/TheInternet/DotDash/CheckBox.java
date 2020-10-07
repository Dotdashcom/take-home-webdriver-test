package TheInternet.DotDash;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CheckBox extends base {
	
	@Test
	public void CheckBoxTest() throws InterruptedException {
		driver.get(URL + "checkboxes ");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]")).click();
		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[2]")).click();
	}

}
