package testdata;



	import java.util.concurrent.TimeUnit;

	import javax.lang.model.element.Element;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	import com.google.common.annotations.VisibleForTesting;

	import io.github.bonigarcia.wdm.managers.VoidDriverManager;

	public class CommonMethods {

		static EvenMethods act;
		
		
		public static void main(String[] args) {
			
			
			
			launchApplication("chrome", "https://admin-demo.nopcommerce.com/login");
			LoginApplication();
			act = new EvenMethods();
			act.createWebelement("xpathType", "Xpathvalue");
			act.click("locator", "locatorvalue");
			act.entertext("locator", "locatorValue", "textToenter");
			
		}
//		@BeforeClass
		public static void launchApplication(String browser, String Url) {

			switch (browser.toLowerCase()) {

			case "chrome":

				System.out.println(" direcotry  " + System.getProperty("user.dir"));

				System.setProperty("webdriver.chrome.driver", GlobalVariables.CHROMEPATH);
				GlobalVariables.driver = new ChromeDriver();
				break;
			case "fireFox":
				System.setProperty("webdriver.gecko.driver", "");

				GlobalVariables.driver = new FirefoxDriver();
				break;

			case "edge":
				System.setProperty("webdriver.edge.driver", "");

				GlobalVariables.driver = new EdgeDriver();

				break;

			case "ie":

				System.setProperty("webdriver.ie.driver", "");

				GlobalVariables.driver = new InternetExplorerDriver();

				break;
			default:

				System.out.println(
						"Unable to launch the application,Use has given wrong browser selection " + browser.toString());
			}

			GlobalVariables.driver.get(Url);

			GlobalVariables.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			GlobalVariables.driver.manage().window().maximize();

			if (GlobalVariables.driver.getCurrentUrl().contains("//")) {
				System.out.println(" Successfully launched Application ");

			} else {
				System.out.println(" Unable to laucnh the application " + Url.toString());
			}

		}

		public static void LoginApplication() {
			
			
			act.entertext("name", "Email", "admin@yourstore.com");
			act.entertext("id", "Password", "admin");
			act.click("xpath", "//button[text()='Log in']");

			WebElement logout = act.createWebelement("xpathtype", "//a[text()='Logout']");

		

			if (logout.isDisplayed()) {

				System.out.println(" Application  is successfully Logined ");

			} else {
				System.out.println("Unabled to login the Application");
			}
			
		} 
			


	}

	
	
	
	
	
	
	
	
	

