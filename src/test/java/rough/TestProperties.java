package rough;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
	public static String getusrname(String username) throws IOException {
		Properties OR = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\OR.Properties");
		OR.load(fis);
		String s = OR.getProperty(username);
		return s;
	}

	public static String gettext(String t) throws IOException {
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Properties\\config.Properties");
		config.load(fis);
		config.getProperty(t);
		return config.getProperty(t);

	}

	public static void main(String[] args) throws IOException {
		getusrname("xpath");
		System.out.println(getusrname("xpath"));
		gettext("text");
		System.out.println(gettext("text"));

	}
}
