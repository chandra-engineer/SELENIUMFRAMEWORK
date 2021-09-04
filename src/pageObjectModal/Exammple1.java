package pageObjectModal;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exammple1 {

	
	
//	public static void main(String[] args) {
//		
//		
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chandra\\eclipse-workspace\\AutomationFramework\\Drivers\\geckodriver.exe");
//		 //To create a new instance of Firefox Driver
//		 WebDriver driver = new FirefoxDriver();
//		 //To open a website "Software Testing Material"
//		 driver.get("https://www.softwaretestingmaterial.com");
//		 //To maximize the browser window
//		 driver.manage().window().maximize();
//		 //This waits up to 15 seconds before throwing a TimeoutException or if it finds the element will return it in 0 - 15 seconds
//		 WebDriverWait wait = new WebDriverWait (driver, 15);
//		 //Title of the webpage is "Software Testing Material - A site for Software Testers"
//		 wait.until(ExpectedConditions.titleIs("Software Testing Material - A site for Software Testers"));
//		 //If the above condition met then the browser will be closed
//		 //To close the browser
//		 driver.close();
//		 //Change the title "Software Testing Material - A site for Software Testers" as "xyz" in the script and try
//		 //You will face an execption - Exception in thread "main" org.openqa.selenium.TimeoutException: Timed out after 20 seconds waiting for title to be "Software Testing Material - A site for Software Tes". Current title: "xyz"
//		 }
//	
	
	
	private WebDriver driver;
	  private String baseUrl;  
	  private WebElement element;
	 
	  @BeforeMethod
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chandra\\eclipse-workspace\\AutomationFramework\\Drivers\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "http://www.google.com";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test 
	  public void testUntitled() throws Exception {
	    driver.get(baseUrl);
	    element = driver.findElement(By.name("q"));
	    element.sendKeys("Selenium");
	    element.sendKeys(Keys.RETURN);
	   List<WebElement> list = driver.findElements(By.className("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/ul/li[5]/div/div[2]/div[1]/span"));
	   System.out.println(list.size());
	  
	  }

	  @AfterMethod
	  public void tearDown() throws Exception {
	    driver.quit();   
	  } 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
