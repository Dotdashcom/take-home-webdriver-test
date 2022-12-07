package Common;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
public class Config {
	public WebDriver driver = null;
	private Properties properties;
	Config () {
		properties = new Properties();
		try {
			FileInputStream file = new FileInputStream("Parameters/config.properties");
			properties.load(file);
			file.close();
		} catch (IOException e) {
			Logger.Log("File not found");
		}
	}
	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}
