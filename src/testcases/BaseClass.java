package testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import freemarker.log.Logger;
  
public class BaseClass {

	public String baseUrl = "http://demo.guru99.com/v4/";
	public String username = "mngr350542";
	public String password = "YtamUmA";
	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
