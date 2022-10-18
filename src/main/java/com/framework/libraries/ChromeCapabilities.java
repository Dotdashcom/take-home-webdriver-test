package com.framework.libraries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Map;

public class ChromeCapabilities {
        ChromeOptions chromeOptions;
        public ChromeCapabilities(){
            this.chromeOptions=new ChromeOptions();
            setupOptions();
            WebDriverManager.chromedriver().useBetaVersions().setup();
        }


    protected ChromeOptions setupOptions() {
        chromeOptions.setExperimentalOption("prefs", Map.of(
                "profile.cookie_controls_mode", 0,
                "profile.block_third_party_cookies", false,
                "profile.default_content_settings.popups", 0,
                "download.prompt_for_download", "false",
                "download.directory_upgrade", "true",
                "download.default_directory", System.getProperty("user.dir") + File.separatorChar + "target"
        ));
        return chromeOptions;
    }
}
