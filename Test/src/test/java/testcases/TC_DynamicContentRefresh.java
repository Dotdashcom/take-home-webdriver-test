package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_DynamicContentRefresh extends BaseClass {

	@Test
	public void VerifyDynamicContentAfterRefresh() throws InterruptedException {
		driver.get("http://localhost:7080/dynamic_content");

		driver. navigate().refresh();
		String text1 =  driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]")).getText();
		System.out.println("Text After first refresh is " + text1);
		Thread.sleep(3000);
		driver. navigate().refresh();
		String text2 =  driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]")).getText();
		System.out.println("Text after second refresh is " + text2);
		if(!text1.equals(text2)){
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);

		}



	}

}


