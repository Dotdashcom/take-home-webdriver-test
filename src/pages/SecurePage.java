import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage {
    private String path = "/secure";

    private By logoutButtonBy = By.xpath("//a[contains(@class,\"button\")]/i[contains(text(),\"Logout\")]");
    private By alertMessageBy = By.xpath("//div[@id='flash']");

    SecurePage(WebDriver webdriver) {
        driver = webdriver;
    }
    public String getUrl() {
        BasePage basePage = new BasePage();
        String url = basePage.getBaseUrl() + path;
        return url;
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButtonBy).click();
    }

    public String getAlertMessage() {
        String msg = driver.findElement(alertMessageBy).getText();
        System.out.println(msg);
        return msg;
    }
}
