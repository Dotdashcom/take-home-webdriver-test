package specs.Login;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pageobjects.Login.Login;
import specs.AbstractSpec;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by PSUSHKOV on Nov, 2020
 **/

// #1 Login Success: http://localhost:7080/login Login pass with valid credentials
// #2 Login Failure: http://localhost:7080/login Login fail invalid credentials
public class CheckLogin extends AbstractSpec {
    private Login login;
    private final String DATA = "data", TEST_NAME = "login";
    private static String sPathToFile, sDataFileJson;

    @BeforeTest
    public void setUp() {
        sPathToFile = System.getProperty("user.dir") + "\\src\\test\\java\\specs\\Login\\json\\";
        sDataFileJson = "dataLogin.json";

        login = new Login(driver);
    }

    @BeforeMethod
    public void setUpTest() {
        // Open the targeted page
        driver.get("http://localhost:7080/login");
    }

    @Test(dataProvider = DATA, priority = 1, enabled = true)
    public void checkLogin(JSONObject data) throws InterruptedException{
        SoftAssert softas = new SoftAssert();

        String actMessage = login.loginForm(data.get("username").toString(), data.get("password").toString());

        // Split test cases for negative and positive
        switch (data.get("test_type").toString()) {

            case "negative":
                // Validate Flash Alert message
                softas.assertTrue(actMessage.contains(data.get("expText").toString()),
                        "Flash Alert message doesn't match expected");

                // Validate Current Page URL
                softas.assertTrue(driver.getCurrentUrl().equals(data.get("expUrl").toString()),
                        "Current Page URL doesn't match expected");

                softas.assertAll();
                break;

            case "positive":
                // Validate Flash Alert message
                softas.assertTrue(actMessage.contains(data.get("expText").toString()),
                        "Flash Alert message doesn't match expected");

                // Validate Current Page URL
                softas.assertTrue(driver.getCurrentUrl().equals(data.get("expUrl").toString()),
                        "Current Page URL doesn't match expected");

                softas.assertAll();
                break;
        }
    }

    @DataProvider(name = DATA)
    public Object[][] simulationData() {
        String sPathToDataFile = sPathToFile + sDataFileJson;

        JSONParser parser = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(sPathToDataFile));
            JSONArray data = (JSONArray) jsonObject.get(TEST_NAME);
            ArrayList<Object> zoom = new ArrayList();

            for (int i = 0; i < data.size(); i++) {
                JSONObject pageObj = (JSONObject) data.get(i);
                if (Boolean.parseBoolean(pageObj.get("do_assertions").toString())) {
                    zoom.add(data.get(i));
                }
            }

            Object[][] newData = new Object[zoom.size()][1];
            for (int i = 0; i < zoom.size(); i++) {
                newData[i][0] = zoom.get(i);
            }

            return newData;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
