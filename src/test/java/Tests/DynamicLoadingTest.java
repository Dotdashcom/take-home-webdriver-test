package Tests;

import Pages.DynamicLoadPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DynamicLoadingTest {
    String baseURL="http://localhost:7080";
    @Test
    public void DynamicLoading(){
        DynamicLoadPage dynamicLoadPage=new DynamicLoadPage();
        Driver.getDriver().get(baseURL+"/dynamic_loading/2");
        dynamicLoadPage.startButton.click();
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(dynamicLoadPage.helloMessage));
        assertTrue(dynamicLoadPage.helloMessage.isDisplayed());
    }
}
