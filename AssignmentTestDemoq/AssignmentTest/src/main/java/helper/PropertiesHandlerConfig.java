package helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHandlerConfig {

	//Project root directory
	private static final String PROJECT_DIR = System.getProperty("user.dir");
	public static final String CONFIGURATION_DIR = PROJECT_DIR + File.separator + "properties" + File.separator;
	private Properties p;

	public void loadProperties(String propFileName) throws InterruptedException {
		try {

			FileInputStream f = new FileInputStream(CONFIGURATION_DIR + propFileName + ".properties");
			p = new Properties();
			p.load(f);
			f.close();

		} catch (Exception e) {
			throw new InterruptedException(propFileName);
		}

	}

	public String getProp(String propName) throws InterruptedException {
		String value = (String) p.get(propName);
		if (value == null)
			throw new InterruptedException(propName);

		return value;

	}

}
