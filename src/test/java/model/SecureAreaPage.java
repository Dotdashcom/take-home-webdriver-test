package model;

import model.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SecureAreaPage extends BasePage {

    @FindBy(css = "h2")
    private WebElement secureAreaHeader;

    @FindBy(css = "#flash")
    private List<WebElement> notificationSuccessMessageList;

    @FindBy(css = "[href*='logout'")
    private List<WebElement> logoutButtonList;


    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getSecureAreaHeader() {

        return secureAreaHeader.getText();
    }

    public boolean isNotificationSuccessLoginDisplayed() {

        return notificationSuccessMessageList.size() > 0;
    }

    public boolean isLogoutButtonDisplayed() {

        return logoutButtonList.size() > 0;
    }
}
