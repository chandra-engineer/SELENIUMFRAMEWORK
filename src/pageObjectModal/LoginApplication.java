package pageObjectModal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginApplication {

	
	@Test
	public static void RegistrationTest() {
	

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chandra\\eclipse-workspace\\AutomationFramework\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
//		RegistrationPage Reg=new RegistrationPage(driver);
		RegistrationPage1 Reg=new RegistrationPage1(driver);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		Reg.clickRegLink();
		Reg.setFirstName("Chandra");
		Reg.setLastName("Sekhar");
		Reg.setPhone("9703446586");
		Reg.setEmail("abcd@gmail.com");
		Reg.setAddress("Tadiptri");
		Reg.setCity("Anantapur");
		Reg.setState("AP");
		Reg.setPostalCode("515411");
		Reg.setCountry("INDIA");
		Reg.setUserName("echandrasekharnaidu@gmail.com");
		Reg.setPassword("eamumc16");
		Reg.setPassword("eamumc16");
		Reg.clickSubmitButton();
		
		
		// validation
		String Expectedtitle="Register: Mercury Tours";
		
		
		if(Expectedtitle.equals(driver.getTitle()))
		{
			System.out.println("Registration is Successfully completed");
		}
		else
		{
			System.out.println("Registration is not successful");
		}
		
		
		
		
		driver.close();
		
		
		
		
	}

}
