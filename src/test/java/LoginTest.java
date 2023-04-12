import org.benjamin.pages.Login;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LoginTest extends Login {
    @ParameterizedTest
    @CsvSource("tomsmith,SuperSecretPassword!")
    public void login_withUNameAndPw_success(String username, String password){
        String classNames = login(username, password);
        Assertions.assertTrue(classNames.contains("success"));
    }


    @ParameterizedTest
    @CsvSource(value = {"tomSmith,incorrectPassword", "incorrectUsername,SuperSecretPassword!", "'',''"})
    public void login_withUNameAndPw_fail(String username, String password){
        String classNames = login(username, password);
        Assertions.assertTrue(classNames.contains("error"));
    }
}
