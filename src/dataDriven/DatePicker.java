package dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {

		String month = "March 2020";
		String day = "20";

////		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\Chandra\\eclipse-workspace\\AutomationFramework\\Drivers\\chromedriver.exe");
//		

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/");
		driver.manage().window().maximize();

		driver.findElement(By.name("//*[@id=\"checkin\"]")).click();

		Thread.sleep(3000);

		while (true) {

			String text = driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[2]")).getText();
			
			if(text.equals(month)) {
				break;
			}else {
				driver.findElement(By.xpath("/html/body/div[4]/div[1]/table/thead/tr[1]/th[1]/i")).click();
			}
			
			
			
			//     /html/body/div[4]/div[1]/table/tbody/tr[2]/td[3]
		}
	}

}
