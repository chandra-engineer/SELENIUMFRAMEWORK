package dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jscript {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Chandra\\eclipse-workspace\\AutomationFramework\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img"));
//		JavaScriptUtil.drawBoarder(element, driver);

	}

	/*
	 * 
	 * public static void drawBorder(WebElement element,WebDriver driver) {
	 * JavascriptExecutor js= (JavascriptExecutor)driver;
	 * 
	 * js.executeScript("nopCommerce demo store",element);
	 * 
	 * }
	 */
	
}
