package dataDriven;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;



public class TakeSceenshot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandra\\eclipse-workspace\\AutomationFramework\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https:/www.google.com/");
		driver.manage().window().maximize();
		
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		
		
	}

}
