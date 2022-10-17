package Assignment;

import Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MouseHover extends TestBase {


    @Test
    public void mouseHoverTest(){

        driver.get(baseUrl + "/hovers");

        List<WebElement> listOfImages = driver.findElements(By.xpath("//div[@class='figure']//img"));

        WebElement caption = driver.findElement(By.xpath("//h5[starts-with(text() , 'name: ')]"));

        WebElement pageFooter = driver.findElement(By.id("page-footer"));

        int originalFooterYAxis = pageFooter.getLocation().y;

        try {
            for (WebElement image : listOfImages) {
                getActions().moveToElement(image).build().perform();
                Assert.assertNotEquals(pageFooter.getLocation().getY() , originalFooterYAxis,"Location check FAILED!");
            }
        } catch (IndexOutOfBoundsException e) {
            Assert.fail("list of images not located!");
        }
    }



    }

