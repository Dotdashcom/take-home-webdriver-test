package com.example.testautomation_dotdash.pages;

import com.example.testautomation_dotdash.base.BasePage;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.example.testautomation_dotdash.base.BaseTest.prop;

public class ContextMenuPage extends BasePage {

    public ContextMenuPage(WebDriver driver)
    {
        super(driver);
        driver.get(prop.getProperty("baseurl") + "/context_menu");
    }

    @FindBy(id = "hot-spot")
    private WebElement boxContext;


    public void rightClickBoxContext(){

        Actions actions = new Actions(driver);
        actions.contextClick(boxContext).build().perform();
    }

    public void assertionOfAlert(){
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        Assert.assertEquals("You selected a context menu", alertText);

        alert.accept();
    }

}
