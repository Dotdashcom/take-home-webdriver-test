package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NotificationMessagePage extends BasePage{
    private final By clickLink = By.linkText("Click here");
    private final By message = By.id("flash");

    public NotificationMessagePage(WebDriver driver) {
        super(driver);
    }

    public void clickLink() {
        wait.until(ExpectedConditions.elementToBeClickable(clickLink));
        getElement(clickLink).click();
    }

    public String getMessage(){
       return getMessage(message);
    }

    public boolean checkMessagesValid(String expectMessage){
        boolean valid = true;
        List<String> expectMessages = Arrays.stream(expectMessage.split(";"))
                .map(String::trim)
                .collect(Collectors.toList());

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(message));
        String actualMessage = getMessage();

        if(!( actualMessage.contains(expectMessages.get(0))||actualMessage.contains(expectMessages.get(1))||actualMessage.contains(expectMessages.get(2)))){
            valid = false;
            return valid;
        }

        return valid;
    }
}
