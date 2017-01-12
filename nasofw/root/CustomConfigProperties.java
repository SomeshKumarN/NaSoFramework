package nasofw.root;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CustomConfigProperties {

	public static Properties properties;

	static {
		try {
			properties = new Properties();
			FileInputStream propertiesFIS = new FileInputStream("nasofw\\settings\\custom.config");
			properties.load(propertiesFIS);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public final static String getValueOf(String key) {
		if (properties.containsKey(key)) {
			return properties.getProperty(key);
		}
		return null;
	}

	public final static void setValueOf(String key, String value) {
		properties.setProperty(key, value);
	}
}
