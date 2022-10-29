package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HoversPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Hovers']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//a[normalize-space()='Elemental Selenium']")
    public WebElement pageFooterLink;

    @FindBy(how = How.XPATH, using = "//div[@class='figure']")
    public List<WebElement> figures;
    private final UITest caller;
    public HashMap<String, String> usersDetails;
    private final String pageUrl;

    public HoversPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        //WebDriverWait pageFactoryInitWait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(10), Duration.ofSeconds(5));
        this.caller.setDriver(driver);
        WebDriverWait wait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(30));
        this.pageUrl = caller.getBaseUrl() + "/hovers";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        this.caller.pageFactoryInitWait(pageTitle);
        //pageFactoryInitWait.until(ExpectedConditions.and(visibilityOf(this.pageTitle),visibilityOf(this.pageFooterLink)));
        wait.until( d-> {
            this.usersDetails = this.getUsersDetails();
            return true;
        });
    }

    public Boolean isPageOpen() { return this.caller.isPageOpen(this.pageUrl, this.pageTitle); }

    public HashMap<String, String> getUsersDetails() {
        Actions builder = new Actions(caller.getDriver());
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        HashMap<String, String> userDetails = new HashMap<>();
        String photo, username;
        for (WebElement f : this.figures) {
            builder.moveToElement(f).perform();
            photo = f.findElement(By.tagName("img")).getAttribute("src");
            username = f.findElement(By.className("figcaption")).findElement(By.tagName("h5")).toString();
            userDetails.put(username, photo);
        }
        return userDetails;
    }

    // To be used in a future testcase
    public Boolean validateUserDetails() {
        final int[] actual = {0};
        int expected = usersDetails.size();

        usersDetails.forEach((key, value) -> {
            if(this.validateHoverOverFigure(key, value)) actual[0]++;
        });
        return actual[0] == expected;
    }

    public Boolean validateHoverOverFigure(String userName, String profilePhoto) {
        for (WebElement figure : this.figures) {
            Boolean photosMatch = figure.findElement(By.tagName("img")).getAttribute("src").equals(profilePhoto);
            Boolean userNameMatch = figure.findElement(By.className("figcaption")).findElement(By.tagName("h5")).toString().equals(userName);
            if ( photosMatch && userNameMatch ) return true;
        }
        return false;
    }

    // To be used in a future testcase
    public WebElement getErrorPageTitle() {
        return caller.getDriver().findElement(By.xpath("//h2[contains(text(),'Sinatra doesn't know this ditty.')]")); }

    public String getErrorPageUrl() {
        return "http://localhost:7080/users/"; }
}