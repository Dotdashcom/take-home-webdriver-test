package pages;


import org.openqa.selenium.By;
import utilities.DriverManager;
import utilities.UtilitiesManager;

public class HomePage extends DriverManager {

    private final By WelcomeNote = By.xpath("//h1[text()='Welcome to the-internet']");

    public boolean VerifyHomePage() {
        UtilitiesManager.ExpectedConditions(WelcomeNote, "DISPLAYED");
        return UtilitiesManager.FindElement(WelcomeNote).isDisplayed();
    }


}
