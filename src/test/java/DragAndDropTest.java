import PageObjects.DragAndDropPage;
import PageObjects.HomePage;
import library.BrowserFactory;
import library.Constants;
import library.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class DragAndDropTest
{

    WebDriver driver;

    @BeforeClass
    public void launchDriver() throws IOException {
        driver = BrowserFactory.launchDriver();
        driver.get(PropertiesFileReader.getBaseURL());
    }

    @Test
    public void dragDropHandle()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnLink(Constants.HomePageConstants.DRAG_AND_DROP_LINKTEXT);
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);
        dragAndDropPage.DragDropActions();
    }

    @AfterClass
    public void quitDriver(){
        if(driver!=null) {
            driver.quit();
        }
    }
}
