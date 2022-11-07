package codingchallengewebsite.ui.pageobjects;

import codingchallengewebsite.ui.UITest;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class HoversPage {

    @FindBy(how = How.XPATH, using = "//h3[normalize-space()='Hovers']")
    public WebElement pageTitle;
    @FindBy(how = How.XPATH, using = "//div[@class='figure']")
    public List<WebElement> figures;
    private final UITest caller;
    private final String pageUrl;

    public HoversPage(@NotNull UITest caller) {
        this.caller = caller;
        WebDriverWait wait = new WebDriverWait(this.caller.getDriver(), Duration.ofSeconds(30));
        this.pageUrl = caller.getBaseUrl() + "/hovers";
        this.caller.getDriver().get(this.pageUrl);
        PageFactory.initElements(this.caller.getDriver(), this);
        this.caller.pageFactoryInitWait(pageTitle);
        wait.until( d-> {
            this.setUsersDetails(this.getUsersDetails());
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
        int expected = getUsersDetails().size();

        getUsersDetails().forEach((key, value) -> {
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

    public void setUsersDetails(HashMap<String, String> usersDetails) {
    }
}