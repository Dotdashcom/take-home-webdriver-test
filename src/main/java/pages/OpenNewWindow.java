package pages;

import org.company.configReader.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.Set;

public class OpenNewWindow {
    private WebDriver driver;
    private SoftAssert softAssert;

    public OpenNewWindow(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class = 'example']/a")
    private WebElement clickHereLink;

    @FindBy(xpath = "//div[@class='example']/h3")
    private WebElement newWindowText;
    
    public void openNewWindowViaLink() {
        navigateToOpenNewWindowPage();
        clickHereLink.click();
        verifyTextInNewWindow();

    }
    private void verifyTextInNewWindow(){
        String parent=driver.getWindowHandle();

        Set<String>s=driver.getWindowHandles();

        Iterator<String> I1= s.iterator();

        while(I1.hasNext())
        {
            String child_window=I1.next();

            if(!parent.equals(child_window)) {
                driver.switchTo().window(child_window);

      //          System.out.println(driver.switchTo().window(child_window).getTitle());
                softAssert.assertEquals(newWindowText.getText().trim(),"New Window","Message is wrong");

                driver.switchTo().window(parent);
            }
        }
    }
    private void navigateToOpenNewWindowPage(){
        driver.get(ConfigReader.getProperty("url")+"/windows");
    }
}
