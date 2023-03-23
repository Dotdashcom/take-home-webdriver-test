package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.Constants;

import java.util.List;

public class Hover extends Constants {

    static String url = "http://localhost:7080/hovers";


    @Test
    public static void testHover(){
        driver.get(url);

        List<WebElement> imgs = driver.findElements(By.xpath("//div[@class='figure']"));
        Actions actions = new Actions(driver);
        int num = 1;
        for(WebElement img : imgs){
            actions.moveToElement(img).build().perform();
            WebElement info = img.findElement(By.tagName("h5"));
            boolean isInfoDisplayed = info.isDisplayed();
            sa.assertEquals(isInfoDisplayed, true);
            String infoString = info.getText();
            sa.assertEquals(infoString.contains("user"+num), true);

            num++;
        }

        sa.assertAll();





    }
}
