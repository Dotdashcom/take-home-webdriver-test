package test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.login_page;
import utils.Browser_Factory;
import utils.ExcelReader;

public class __1_Login_test {

        WebDriver driver;
        String login = "login";
        ExcelReader XLR = new ExcelReader("Test_data\\login_data.xlsx");
        String UserName = XLR.getCellData("Logininfo", "UserName", 2);
        String PassWord = XLR.getCellData("Logininfo", "PassWord", 2);

        @BeforeClass
        public void browser_fact_before() {
            driver = Browser_Factory.init_browser();
        }

        @Test()
        public void LoginData() {
            Browser_Factory.init_url(login);
            login_page Pagex = PageFactory.initElements(driver, login_page.class);
            Pagex.login_meth(UserName, PassWord);
        }

        @AfterClass
        public void browser_fact_After() throws InterruptedException {
//            driver = Browser_Factory.teardown();
        }

    }
