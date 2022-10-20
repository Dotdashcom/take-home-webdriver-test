package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

public class DynamicContentPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Dynamic Content']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@href and text()= 'click here']")
    private WebElement clickHereLink;
    @FindBy(how = How.XPATH, using = "//*[@class='large-10 columns']")
    private WebElement dynamicText;
    @FindBy(how = How.XPATH, using = "//*[@class='large-2 columns']")
    private WebElement dynamicImages;
    private UITests caller;
    private final String pageUrl;
    public WebDriver driver;

    public DynamicContentPage (WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/dynamic_content").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpen() {
        // Check that the page loaded
        return driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Dynamic Content");
    }

    public void reloadPage() { caller.reloadPage(this.driver) ;}

    public HashMap<String, String> getContent(Boolean partial) {
        if (partial.equals(false)) this.driver.get(this.pageUrl);
        String staticContentQueryString = "?with_content=static";
        if (partial.equals(true)) this.driver.get(this.pageUrl + staticContentQueryString);

        List<WebElement> rawImages = this.driver.findElements(By.xpath("(//*[@class='large-2 columns'])"));
        List<WebElement> rawTexts = this.driver.findElements(By.xpath("(//*[@class='large-10 columns'])"));
        List<String> tempList = new ArrayList<>();
        HashMap<String, String> content = new HashMap<String, String>();

        // Get the images
        for (WebElement image : rawImages) {
            tempList.add(image.findElement(By.tagName("img")).getAttribute("src").toString());
        }
        // Get the text and build the hashmap
        int index = 0;
        for (WebElement text : rawTexts) {
            content.put(tempList.get(index), text.getText().toString());
            index++;
        }

        return content;
    }
}
