package shakilTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHoverTest_14 extends TestBase {

    @Test
    public void testMouseHover() {
        driver.get("http://localhost:7080/hovers");

        // Find the elements to hover over
        WebElement image1 = driver.findElement(By.xpath("/html//div[@id='content']/div/div[1]/img[@alt='User Avatar']"));
        WebElement image2 = driver.findElement(By.xpath("/html//div[@id='content']/div/div[2]/img[@alt='User Avatar']"));
        WebElement image3 = driver.findElement(By.xpath("/html//div[@id='content']/div/div[3]/img[@alt='User Avatar']"));

        // Create an Actions object to perform the hover
        Actions action = new Actions(driver);

        // Hover over the first image and verify that the additional content is displayed
        action.moveToElement(image1).perform();
        WebElement additionalContent1 = driver.findElement(By.xpath("/html//div[@id='content']//h5[.='name: user1']"));
        Assert.assertTrue(additionalContent1.isDisplayed(), "Additional content is not displayed for image 1");

        // Hover over the second image and verify that the additional content is displayed
        action.moveToElement(image2).perform();
        WebElement additionalContent2 = driver.findElement(By.xpath("/html//div[@id='content']//h5[.='name: user2']"));
        Assert.assertTrue(additionalContent2.isDisplayed(), "Additional content is not displayed for image 2");

        // Hover over the third image and verify that the additional content is displayed
        action.moveToElement(image3).perform();
        WebElement additionalContent3 = driver.findElement(By.xpath("/html//div[@id='content']//h5[.='name: user3']"));
        Assert.assertTrue(additionalContent3.isDisplayed(), "Additional content is not displayed for image 3");
    }
}


/*
 * 
 * 
 * 
 * 
 * 
 * 
 * elemet to hoover /html//div[@id='content']/div/div[1]/img[@alt='User Avatar']
 * /html//div[@id='content']/div/div[2]/img[@alt='User Avatar']
 * /html//div[@id='content']/div/div[3]/img[@alt='User Avatar']
 * 
 * 
 * elemet to assert visible /html//div[@id='content']//h5[.='name: user1']
 * /html//div[@id='content']//h5[.='name: user2']
 * /html//div[@id='content']//h5[.='name: user3']
 * 
 * 
 * 
 * 
 */
