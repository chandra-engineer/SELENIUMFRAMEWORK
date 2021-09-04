package dataDriven;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;



public class TakeSceenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
	/*	// full page screenshot
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\Chandra\\eclipse-workspace\\AutomationFramework\\Drivers\\homepage.png");
		FileUtils.copyFile(src,target);
		
		*/
		//screenshot of portion/selection
	/*	WebElement section=	driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div"));
	
		File src=section.getScreenshotAs(OutputType.FILE);
		
		File target=new File("C:\\Users\\Chandra\\eclipse-workspace\\AutomationFramework\\Drivers\\section.png");
		FileUtils.copyFile(src,target);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		*/
		
		WebElement element=	driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
		
		File src=element.getScreenshotAs(OutputType.FILE);
		
//		File target=new File("C:\\Users\\Chandra\\eclipse-workspace\\AutomationFramework\\Drivers\\element.png");
		File target= new File(System.getProperty("user.dir")+"\\Drivers\\ele.ping");
		FileUtils.copyFile(src,target);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}

}
