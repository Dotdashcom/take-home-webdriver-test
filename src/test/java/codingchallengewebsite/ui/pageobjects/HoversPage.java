package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class HoversPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Hovers']")
    private WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='figure']")
    private List<WebElement> figures;
    private UITest caller;
    public HashMap<String, String> usersDetails;
    private final String pageUrl;

    public HoversPage(RemoteWebDriver driver, UITest caller) {
        this.caller = caller;
        this.caller.setDriver(driver);
        WebDriverWait wait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(30));
        this.pageUrl = new StringBuilder(caller.getBaseUrl()).append("/hovers").toString();
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(driver, this);
        wait.until( d-> {
            this.usersDetails = this.getUsersDetails();
            return true;
        });
    }

    public boolean isPageOpen() {
        return caller.getDriver().getCurrentUrl().equals(this.pageUrl) && this.pageTitle.getText().toString().contains("Hovers"); }

    public HashMap<String, String> getUsersDetails() {
        Actions builder = new Actions(caller.getDriver());
        WebDriverWait wait = new WebDriverWait(caller.getDriver(), Duration.ofSeconds(30));
        HashMap<String, String> userDetails = new HashMap<>();
        String photo, username;
        for (WebElement f : this.figures) {
            builder.moveToElement(f).perform();
            photo = f.findElement(By.tagName("img")).getAttribute("src").toString();
            username = f.findElement(By.className("figcaption")).findElement(By.tagName("h5")).toString();
            userDetails.put(username, photo);
        }
        return userDetails;
    }

    public boolean validateUserDetails () {
        final int[] actual = {0};
        int expected = usersDetails.size();

        usersDetails.forEach((key, value) -> {
            if(this.validateHoverOverFigure(key, value)) actual[0]++;
        });
        return actual[0] == expected;
    }

    public boolean validateHoverOverFigure(String userName, String profilePhoto) {
        HashMap<String, String> userDetails = new HashMap<>();
        Actions builder = new Actions(caller.getDriver());

        for (WebElement figure : this.figures) {
            boolean photosMatch = figure.findElement(By.tagName("img")).getAttribute("src").toString().equals(profilePhoto);
            boolean userNameMatch = figure.findElement(By.className("figcaption")).findElement(By.tagName("h5")).toString().equals(userName);
            if ( photosMatch && userNameMatch ) return true;
        }
        return false;
    }

    public WebElement getErrorPageTitle() {
        return caller.getDriver().findElement(By.xpath("//h2[contains(text(),'Sinatra doesn't know this ditty.')]")); }

    public String getErrorPageUrl() {
        return "http://localhost:7080/users/"; }
}