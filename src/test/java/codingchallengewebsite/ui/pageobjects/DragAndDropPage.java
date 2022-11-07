package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;

public class DragAndDropPage {
    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Drag and Drop']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='column-a']")
    public WebElement boxA;
    @FindBy(how = How.XPATH, using = "//*[@id='column-a']/header")
    public WebElement boxOne;
    @FindBy(how = How.XPATH, using = "//*[@id='column-b']")
    public WebElement boxB;
    @FindBy(how = How.XPATH, using = "//*[@id='column-b']/header")
    public WebElement boxTwo;
    private final UITest caller;
    private final HashMap<String, WebElement> boxes = new HashMap<>();
    private final HashMap<String, WebElement> letters = new HashMap<>();
    private final String pageUrl;

    public DragAndDropPage(UITest caller) {
        this.caller = caller;
        this.pageUrl = this.caller.getBaseUrl() + "/drag_and_drop";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
        this.boxes.put("boxA", this.boxA);
        this.boxes.put("boxB", this.boxB);
        this.letters.put("boxOne", this.boxOne);
        this.letters.put("boxTwo", this.boxTwo);
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public void dragAndDropBox(String source, String destination) {
        WebDriverWait wait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.boxes.get(source)));
        wait.until(ExpectedConditions.visibilityOf(this.boxes.get(destination)));
        caller.dragAndDropJS(this.boxes.get(source), this.boxes.get(destination)); }

    public String getBoxLetter(String box) {
        WebDriverWait wait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.letters.get(box)));
        return this.letters.get(box).getText(); }
}