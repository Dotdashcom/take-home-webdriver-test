package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicContentPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Dynamic Content']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@href and text()= 'click here']")
    public WebElement clickHereLink;
    @FindBy(how = How.XPATH, using = "//*[@class='large-10 columns']")
    public WebElement dynamicText;
    @FindBy(how = How.XPATH, using = "//*[@class='large-2 columns']")
    public WebElement dynamicImages;
    private final UITest caller;
    private final String pageUrl;

    public DynamicContentPage (UITest caller) {
        this.caller = caller;
        this.pageUrl = this.caller.getBaseUrl() + "/dynamic_content";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public void reloadPage() { UITest.reloadPage(caller.getDriver()); }

    public HashMap<String, String> getContent(@NotNull Boolean partial) {
        if (partial.equals(false)) caller.getDriver().get(this.pageUrl);
        String staticContentQueryString = "?with_content=static";
        if (partial.equals(true)) caller.getDriver().get(this.pageUrl + staticContentQueryString);

        List<WebElement> rawImages = caller.getDriver().findElements(By.xpath("(//*[@class='large-2 columns'])"));
        List<WebElement> rawTexts = caller.getDriver().findElements(By.xpath("(//*[@class='large-10 columns'])"));
        List<String> tempList = new ArrayList<>();
        HashMap<String, String> content = new HashMap<String, String>();

        // Get the images
        for (WebElement image : rawImages) {
            tempList.add(image.findElement(By.tagName("img")).getAttribute("src"));
        }
        // Get the text and build the hashmap
        int index = 0;
        for (WebElement text : rawTexts) {
            content.put(tempList.get(index), text.getText());
            index++;
        }
        return content;
    }
}