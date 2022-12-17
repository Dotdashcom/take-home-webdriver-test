package Tests;

import Pages.BasePage;
import Pages.NewTab_WindowsPage;
import Utils.Driver;
import Utils.HelpfulMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class NewTabVerification extends BasePage {

    NewTab_WindowsPage newTab_windowsPage = new NewTab_WindowsPage();

    @BeforeClass
    public void SetUp(){
        Driver.GetDriver().get("http://localhost:7080/windows");
    }

    @Test
    public void TC1HandleWindows() throws IOException {
        newTab_windowsPage.ClickLink();
        ArrayList<String> handles = new ArrayList<>(Driver.GetDriver().getWindowHandles());
        Driver.GetDriver().switchTo().window(handles.get(1));
        String newTabText = newTab_windowsPage.NewTabMessage();
        Assert.assertTrue(newTabText.equalsIgnoreCase("New Window"));
        HelpfulMethods.takeScreenShot("NewTab verification");

    }
    }

