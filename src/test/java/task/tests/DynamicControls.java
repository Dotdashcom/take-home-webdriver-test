package task.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import task.pages.DynamicControlsPage;
import task.utilities.Driver;

import java.time.Duration;

public class DynamicControls extends DynamicControlsPage {

    DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();


    @BeforeEach
    public void setUp(){
        Driver.getDriver().get("http://localhost:7080/dynamic_controls");
    }


    @Test
    public void testDynamicControls(){

        removeButton.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));


        boolean checkBoxPresence = Driver.getDriver().findElements(By.id("checkbox")).size() > 0;
        Assertions.assertTrue(!checkBoxPresence);


        addButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));


        checkBoxPresence = Driver.getDriver().findElements(By.id("checkbox")).size() > 0;
        Assertions.assertTrue(checkBoxPresence);


        enableButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(inputField));


        boolean isEnabled = inputField.isEnabled();
        Assertions.assertTrue(isEnabled);
    }




    @AfterEach
    public void tearDown(){
        Driver.closeDriver();
    }
}
