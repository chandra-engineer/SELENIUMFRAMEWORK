package java.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class ReadConfig {

	static Properties pro;

	public ReadConfig() {
		File src = new File("./Configaration\\config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is   " + e.getMessage());
		}

	}

	public static void main(String[] args) {
		ReadConfig rd = new ReadConfig();

		HashMap<String, String> configData = rd.readValuesFromConfig("");
		String userName = configData.get("userName");

	}

	public static HashMap<String, String> readValuesFromConfig(String filaPath) {
		HashMap<String, String> configData = new HashMap<String, String>();

		try {
			File src = new File(filaPath);

			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

			Set<Object> allKeys = pro.keySet();

			for (Object key : allKeys) {

				Object keyValue = pro.get(key);

				configData.put((String) key, (String) keyValue);

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return configData;

	}

	public String getApplicationUrl() {

		String url = pro.getProperty("baseUrl");
		return url;
	}

	public String getUserName() {

		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {

		String password = pro.getProperty("password");
		return password;
	}

	public String getChromepath() {

		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirefoxpath() {

		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}

	public String getEdgepath() {

		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}

}
