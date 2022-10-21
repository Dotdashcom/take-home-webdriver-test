package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.HashMap;

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
    private final UITest caller;
    private HashMap<String, WebElement> boxes = new HashMap<>();
    private HashMap<String, WebElement> letters = new HashMap<>();
    private String pageUrl;

    public DragAndDropPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        this.pageUrl = this.caller.getBaseUrl() + "/drag_and_drop";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.boxes.put("boxA", this.boxA);
        this.boxes.put("boxB", this.boxB);
        this.letters.put("boxOne", this.boxOne);
        this.letters.put("boxTwo", this.boxTwo);
    }

    public boolean isPageOpen() {
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().contains("Drag and Drop"); }

    public void dragAndDropBox(String source, String destination) {
        caller.dragAndDropJS(this.boxes.get(source), this.boxes.get(destination)); }

    public String getBoxLetter(String box) {
        return this.letters.get(box).getText(); }
}