package java.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import freemarker.log.Logger;

public class BaseClassReadconfig {

	public static WebDriver driver;
	public static Logger logger;
	public static ReadConfig configData;

	public static GlobalVariables gVar;
//	public  static HashMap<String,String > configData;
	String path = "";

	@SuppressWarnings("static-access")
	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void setUp(String br, String configfilepath) {

		try {

			GlobalVariables gvar = new GlobalVariables();

			logger = Logger.getLogger("ebanking");

			// configData = new ReadConfig();

			String path = ConfigFilePath(configfilepath);

			gVar.ConfigData = readValuesFromConfig(path);

			PropertyConfigurator.configure("Log4j.properties");

			if (br.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (br.equals("firefox")) {
				System.setProperty("webdriver.chrome.driver", path);
				driver = new FirefoxDriver();
			} else if (br.equals("edge")) {
				System.setProperty("webdriver.chrome.driver", path);
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot has taken");

	}

	public boolean isAlertPresent() // user defined method is created to check alert is [resent or not
	{
		try {

			driver.switchTo().alert();
			return true;

		} catch (NoAlertPresentException e) {

		}
		return false;
	}

	public String ConfigFilePath(String env) {

		String path = null;

		switch (env.trim().toLowerCase()) {

		case "qa":

			path = gVar.QAConfigPath;

			break;

		case "dev":

			path = gVar.DEVConfigPath;

			break;

		case "sit":

			path = gVar.SITConfigPath;

			break;

		case "uat":

			path = gVar.UATConfigPath;

			break;
		case "regression":

			path = gVar.REGRESSIONConfigPath;

			break;

		default:

			System.out.println(" Please provide the valide Environment ");

			break;
		}
		System.out.println(" Config File path " + path);
		return path;

	}

	public HashMap<String, String> readValuesFromConfig(String filaPath) {
		HashMap<String, String> configData = new HashMap<String, String>();
		Properties pro;
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
		System.out.println(" Config Data " + configData);
		return configData;

	}

}
