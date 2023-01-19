package Pages;

import Helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;

public class DragAndDrop_Page {
    public WebDriver driver;
    public Helpers helpers;

    public DragAndDrop_Page(WebDriver driver){
        this.driver = driver;
        helpers = new Helpers(driver);
    }

    // WEB ELEMENT // WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT //WEB ELEMENT

    public By area_column_div_1 = By.id("column-a");
    public By area_column_div_2 = By.id("column-b");


    // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES // FUNCIONES

    //TODO: EVEN WHEN ITS SEEMS EASY, THERE IS A ISSUE RELATED TO THIS: https://github.com/SeleniumHQ/selenium/issues/3269
    public void GoToDnDPage(){
        driver.navigate().to(driver.getCurrentUrl()+"drag_and_drop ");
    }
    public void MoveElements(){

        //helpers.DragNDrop(area_column_div_1, area_column_div_2);
        helpers.DragNDrop2(area_column_div_1, area_column_div_2);

    }
    public void AssertChange() {
        helpers.Wait(10);
        Assert.assertEquals(helpers.getText(area_column_div_1), "B", "Column A should have B");
        Assert.assertEquals(helpers.getText(area_column_div_2), "A","Column B should have A" );


    }
}
