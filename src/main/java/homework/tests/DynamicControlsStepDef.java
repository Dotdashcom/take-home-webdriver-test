package homework.tests;

import homework.pages.DynamicControlsPage;
import homework.test.TestBase;
import homework.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControlsStepDef extends TestBase {

    DynamicControlsPage dynamicControlsPage=new DynamicControlsPage();

    @Test
    public void verifyDynamicControl(){

    Driver.getDriver().get("http://localhost:7080/dynamic_controls");

    dynamicControlsPage.removeButton.click();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));

    String expectedText= "It's gone!";
    String checkBoxAfter=Driver.getDriver().findElement(By.xpath("//p[@id='message']")).getText();

    Assert.assertEquals(checkBoxAfter,expectedText);


    dynamicControlsPage.addButton.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));

    Assert.assertTrue(dynamicControlsPage.checkBoxAfterAddbutton.isDisplayed());

    dynamicControlsPage.enableButton.click();
    wait.until(ExpectedConditions.elementToBeClickable(dynamicControlsPage.enabledMessage));

    Assert.assertTrue(dynamicControlsPage.enabledMessage.isDisplayed());

    dynamicControlsPage.disableButton.click();
    wait.until(ExpectedConditions.visibilityOf(dynamicControlsPage.disableMessage));

    Assert.assertTrue(dynamicControlsPage.disableMessage.isDisplayed());


    }


}
