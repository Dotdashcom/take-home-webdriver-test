package com.mitt.pages;

import com.mitt.core.BasePage;
import com.mitt.core.Log;
import com.mitt.core.PropertyFileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class NewWindowPage extends BasePage {

    private final By clickhere_xpath = By.xpath("//div[@id='content']/div/a");

    public NewWindowPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        getDriver().get(PropertyFileReader.getInstance().getProperty("open_in_new_tab_url"));
    }

    public void windowVerification() throws InterruptedException {

        findElement(clickhere_xpath).click();
        String parent=getDriver().getWindowHandle();
        Set<String> s=getDriver().getWindowHandles();
        Iterator<String> I1= s.iterator();
        while(I1.hasNext())
        {
            String child_window=I1.next();
            if(!parent.equals(child_window))
            {
                getDriver().switchTo().window(child_window);
                Assert.assertTrue(getDriver().switchTo().window(child_window).getTitle().equals("New Window"));
            }
        }
        getDriver().switchTo().window(parent);
        Log.info("New window validated Successfully");
    }
}
