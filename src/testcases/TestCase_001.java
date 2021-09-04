package testcases;

import java.utilities.BaseClassReadconfig;
import java.utilities.GlobalVariables;
import java.utilities.ReadConfig;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModal.LoginPage;

public class TestCase_001 extends BaseClassReadconfig {

	@Test()
	public void loginTest() {
		try {

			driver.get(GlobalVariables.ConfigData.get("baseUrl"));
			logger.info("URL is Opened");
			driver.manage().window().maximize();

			LoginPage lp = new LoginPage(driver);

//			ReadConfig rd1 = new ReadConfig();

			lp.setUserName(GlobalVariables.ConfigData.get("UserName"));
			logger.info("Entered username");
			lp.setPassword(GlobalVariables.ConfigData.get("password"));
			logger.info("Entered password");
			if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
				Assert.assertTrue(true);
				logger.info("Login test is passed");
			} else {
				Assert.assertFalse(false);
				logger.info("Login test is failed");

			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
