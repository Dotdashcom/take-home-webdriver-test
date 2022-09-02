package Tests;

import org.junit.jupiter.api.Test;
import utilities.Driver;

public class FloatingMenuTest {

    @Test
    public void floatingMenu(){

        Driver.getDriver().get("http://localhost:7080/floating_menu");
    }
}
