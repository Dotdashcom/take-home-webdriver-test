package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC_MouseHover extends BaseClass{

	@Test
	public void VerifyMouseHover() {

		driver.get("http://localhost:7080/hovers");

		By images = By.cssSelector(".figure");
		By usercaption =By.cssSelector(".figcaption h5");
		List<WebElement> imagelist =driver.findElements(images);
		List<WebElement>  caption = driver.findElements(usercaption);
	
		for(int x=0;x<caption.size();x++){

				Actions actions=new Actions(driver);
				actions.moveToElement(imagelist.get(x)).build().perform();
				System.out.println("Item By index"+caption.get(x).getText());
				if(caption.get(x).isDisplayed())
				{
					Assert.assertTrue(true); 
				}
			
		}
	}






























/*	Actions act = new Actions(driver);
			act.moveToElement(user1).perform();
			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).getText());


			act.moveToElement(user2).perform();
			System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5")).getText());

			act.moveToElement(user3).perform();

			 if(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5")).isDisplayed()

        	  if(imagelist.get(1).getText().contains("user2")){
        		  if(imagelist.get(2).getText().contains("user2")){

        			  Assert.assertTrue(true);
        			  System.out.println("pass");
 *
 */


}


