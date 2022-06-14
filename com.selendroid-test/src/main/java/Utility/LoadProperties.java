package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class LoadProperties {

	//path of framework config file should be here

	String filePath = "config/config.properties";
	Properties prop;

	private static LoadProperties instance = null;

	private LoadProperties() {
		File file;
		FileInputStream fis;
		try {
			file = new File(filePath);
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static LoadProperties getInstance() {
		if (instance == null) {
			instance = new LoadProperties();
		}
		return instance;
	}
	//get  property value from config file

	public String getValue(String key) {
		return prop.getProperty(key);
	}

	public void setValue(String key, String value) {
		File file;
		FileOutputStream fos;
		try {
			file = new File(filePath);
			fos = new FileOutputStream(file);
			prop = new Properties();
			prop.setProperty(key, value);
			prop.store(fos, "Last updated key: " + key);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
