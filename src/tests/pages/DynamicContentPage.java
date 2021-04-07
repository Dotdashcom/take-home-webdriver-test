package pages;
import com.google.sitebricks.client.Web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class DynamicContentPage {

    public WebDriver driver;

    @FindBy(xpath = "//img")
    public List<WebElement> url_Images;

    @FindBy(xpath = "//*[@class='large-10 columns']")
    public List<WebElement>  text_Contents;

    @FindBy(xpath = "//*[@id=\"start\"]/button")
    public WebElement  button_Start;

    @FindBy(xpath = "//*[@id=\"finish\"]/h4")
    public WebElement  text_Finish;

    public DynamicContentPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void verifyDynamicContentOnRefresh(){
        String img1_url = url_Images.get(0).getAttribute("src");
        String img2_url = url_Images.get(1).getAttribute("src");
        String img3_url = url_Images.get(2).getAttribute("src");
        String text_Content1 = text_Contents.get(0).getAttribute("text");
        String text_Content2 = text_Contents.get(1).getAttribute("text");
        String text_Content3 = text_Contents.get(2).getAttribute("text");
        driver.navigate().refresh();
        Assert.assertTrue(!url_Images.get(0).getAttribute("src").equalsIgnoreCase(img1_url)&&
                !url_Images.get(1).getAttribute("src").equalsIgnoreCase(img2_url)&&
                !url_Images.get(2).getAttribute("src").equalsIgnoreCase(img3_url)&&
                !text_Contents.get(0).getAttribute("text").equalsIgnoreCase(text_Content1)&&
                !text_Contents.get(1).getAttribute("text").equalsIgnoreCase(text_Content2)&&
                !text_Contents.get(2).getAttribute("text").equalsIgnoreCase(text_Content3),"Content not changed on refresh");
        }

    public void verifyDynamicTextWithExplicitWait(){
        button_Start.click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
        Assert.assertTrue(text_Finish.getAttribute("text").equalsIgnoreCase("Hello World!"),"text not displayed as expected.");
     }

}


