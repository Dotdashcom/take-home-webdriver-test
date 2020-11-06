package Tests;

import PageRepositories.Login;
import Utils.UITestListeners;
import Utils.Utils;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.io.IOException;

@Listeners({ UITestListeners.class })
public class LoginSuccessTest extends BaseTest {
    @Test(priority=1)
    @Description("Successful Login to Internet")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Login")
    public void successful_login() throws IOException {
        Utils utils = new Utils();
        Login login = new Login(driver);

        String user_name;
        user_name = utils.read_from_config_file("config", "user_name");
        password = utils.read_from_config_file("config", "password");

        login.navigate_to_login_page(base_url);
        login.validate_login_page_header();
        login.enter_user_name(user_name);
        login.enter_user_password();
        login.click_login_button();
        login.verify_login_to_secure_area_page();
    }
}
