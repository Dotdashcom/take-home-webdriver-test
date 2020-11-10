package Tests;

import PageRepositories.Login;
import Utils.UITestListeners;
import Utils.Utils;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners({ UITestListeners.class })
public class LoginFailureTest extends BaseTest {
    @Test(priority=1, dataProvider = "login_failure_data")
    @Description("Login Failure Tests to Internet")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Login")
    @Step ("Test Scenario - [{0}]")
    public void login_failure(String test_scenario, String user_name, String password, String expected_result) {
        Login login = new Login(driver);

        login.navigate_to_login_page(base_url);
        login.validate_login_page_header();
        login.enter_user_name(user_name);
        login.enter_user_password(password);
        login.click_login_button();
        login.invalid_login_check(test_scenario, expected_result);
    }

    @DataProvider(name="login_failure_data")
    public Object[][] login_failure_data() throws IOException {
        Utils utils = new Utils();
        Object [][] array_object = utils.read_excel("src/test/java/Data/LoginFailure.xlsx", "Sheet1");
        return array_object;
    }
}
