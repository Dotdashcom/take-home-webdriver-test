import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import util.Constants;

import java.util.List;

class DropdownTest {

    WebDriver driver;

    static String url = "/dropdown";

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.baseUrl+ url);
    }

    @Test
    void dropdownSelectItemsTest() {

        Select select = new Select(driver.findElement(By.id("dropdown")));

        List<WebElement> options = select.getOptions();

        boolean selectItemsOk = false;

        for (WebElement option : options) {
            if (option.isEnabled()) {
                select.selectByVisibleText(option.getText());
                WebElement selectedOption = select.getFirstSelectedOption();
                if (selectedOption.isSelected() &&
                        selectedOption.getText().compareTo(option.getText()) == 0) {
                    selectItemsOk = true;
                } else {
                    selectItemsOk = false;
                    break;
                }
            }
        }

        assert selectItemsOk;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}