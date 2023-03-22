
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtils {

	private static DriverUtils instance = null;

	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	private DriverUtils() // No one can instantiate this class outside of this class due to this private
							// empty constructor
	{
	}

	/**
	 * In such situation there may be three or more threads which are waiting on the
	 * synchronized block to get access. Since we have used synchronized only one
	 * thread will be given access. All the remaining threads which were waiting on
	 * the synchronized block will be given access when first thread exits this
	 * block.
	 */
	public static DriverUtils getInstance() {
		if (instance == null) {
			// instance = new DriverUtils();
			synchronized (DriverUtils.class) {
				if (instance == null) {
					instance = new DriverUtils();
				}
			}
		}
		return instance;
	}

	public final void setDriver(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver(getChromeOptions()));
		}
	}

	public WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * BROWSER OPTIONS CONFIGURATION
	 * ----------------------------------------------------------------------- What
	 * do you want your browsers to do before WebDriver takes over
	 */
	// Get Chrome Options
	private static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--remote-allow-origins=*");
		// options.addArguments("--incognito");
		return options;
	}

}
