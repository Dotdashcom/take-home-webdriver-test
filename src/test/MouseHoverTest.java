package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.CommonMethods;

import java.util.List;
@Test
public class MouseHoverTest extends CommonMethods {
    public static void main(String[] args) throws InterruptedException {
        setUp("http://localhost:7080/hovers");

        List<WebElement> images = driver.findElements(By.cssSelector("img[alt = 'User Avatar']"));
        List<WebElement> additionalInformationTexts = driver.findElements(By.xpath("//h5[contains(text(), 'name: ')]"));

        Actions action = new Actions(driver);

        //looping through all images and checking if additional information is displayed on each image
        for (WebElement image : images) {
            action.moveToElement(image).perform();
            Thread.sleep(1000);
            for (WebElement additionalInformationText : additionalInformationTexts) {
                if (additionalInformationText.isDisplayed()) {
                    System.out.println("The test is passed. Additional information is displayed for the image");
                    break;
                }
            }
        }
        tearDown();
    }
}

