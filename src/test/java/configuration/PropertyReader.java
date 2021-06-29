package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
	
	public static String getPropertiesFromFile(String file, String property) throws IOException {
		InputStream input = null;
		Properties props = null;
		
		try {
			input = new FileInputStream(file);
			props = new Properties();
			props.load(input);
			System.out.println("Got props " + props);
		} catch (Exception e){
			System.out.println("Error - " + e.getMessage());
		} finally {
			input.close();
		}
			
		return props.getProperty(property);		
	}
}
