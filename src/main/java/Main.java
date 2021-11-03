import setup.Setup;

public class Main {

    public static void main(String args[])
    {
        Setup initSetup = new Setup();
        initSetup.setup();
        initSetup.test_login_success();
        initSetup.test_login_failure();
        initSetup.test_check_checkbox();
        initSetup.test_uncheck_checkbox();
    }
}
