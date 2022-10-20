package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;

import static codingchallengewebsite.ui.UITests.DEFAULT_BASE_URL;

public class DragAndDropPage {
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Drag and Drop']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='column-a']")
    private WebElement boxA;
    @FindBy(how = How.XPATH, using = "//*[@id='column-a']/header")
    private WebElement boxOne;
    @FindBy(how = How.XPATH, using = "//*[@id='column-b']")
    private WebElement boxB;
    @FindBy(how = How.XPATH, using = "//*[@id='column-b']/header")
    private WebElement boxTwo;
    private final UITests caller;
    private final HashMap<String, WebElement> boxes = new HashMap<String, WebElement>();
    private final HashMap<String, WebElement> letters = new HashMap<String, WebElement>();
    private final String pageUrl;
    public WebDriver driver;

    public DragAndDropPage(WebDriver driver, UITests caller) {
        this.caller = caller;
        this.driver = driver;
        this.pageUrl = new StringBuilder().append(DEFAULT_BASE_URL).append("/drag_and_drop").toString();
        this.driver.get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.boxes.put("boxA", this.boxA);
        this.boxes.put("boxB", this.boxB);
        this.letters.put("boxOne", this.boxOne);
        this.letters.put("boxTwo", this.boxTwo);
    }

    public boolean isPageOpen() {
        return this.driver.getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Drag and Drop");
    }

    public void dragAndDropBox(String source, String destination) {
        caller.dragAndDropJS(this.boxes.get(source), this.boxes.get(destination));
    }

    public String getBoxLetter(String box) {
        return this.letters.get(box).getText().toString();
    }
}
