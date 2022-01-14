package methods;

import org.openqa.selenium.By;
import model.OpenNewTabPage;

public class OpenNewTabMethod extends GeneralTestMethod{
    private final String openNewTabURL = "http://localhost:7080/windows";
    private final String newTabURL = "http://localhost:7080/windows/new";
    OpenNewTabPage openNewTabPage;

    public void startOpenNewTabTest() {
        driver.get(openNewTabURL);
        openNewTabPage = new OpenNewTabPage(driver);
        openNewTabPage.clickComponent().click();

    }

    public String getContent() {
        driver.get(newTabURL);
        return driver.findElement(By.className("example")).getText();
    }
}
