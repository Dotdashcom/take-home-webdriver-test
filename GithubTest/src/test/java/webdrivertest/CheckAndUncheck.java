package webdrivertest;

import common.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CheckAndUncheck extends Base {
    WebDriver driver;

    @Test
    public void checkUncheckBox(){
        driver = getDriver();
        driver.get("http://localhost:7080/checkboxes");

        /* In order to do the checkbox first I had to find the locator I want to check
           and then I just to invoke the click() method
           Then, I have used isSelected method just to check if it is checked.
            */
       WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
       checkbox.click();

       if(checkbox.isSelected()){
           System.out.println("CheckBox is Checked");
       }


        /* In order to do the unchecked first I had to find the locator I want to check
           and then I just have to invoke the click() method.
           Then I have used isSelected method just to check if it is unchecked
         */
        WebElement unchecked = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        unchecked.click();

        if(!unchecked.isSelected()){
            System.out.println("CheckBox is now unchecked");
        }



    }

}
