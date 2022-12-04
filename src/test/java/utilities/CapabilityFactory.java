package utilities;

import org.openqa.selenium.Capabilities;

import java.io.IOException;

public class CapabilityFactory {
    Capabilities capabilities;
    OptionsManager optionsManager;
    public Capabilities getCapabilities (String browser) throws IOException {
        optionsManager = new OptionsManager();
        if (browser.equals("chrome"))
            capabilities = optionsManager.getChromeOptions();
        return capabilities;
    }
}