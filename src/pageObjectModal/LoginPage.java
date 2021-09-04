package pageObjectModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
WebDriver ldriver;
	
	 public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(name="uid")  WebElement textUsername;
	@FindBy(name="password")  WebElement textPassword;
	@FindBy(name="btnLogin")  WebElement LoginButton;
	@FindBy(xpath="//a[text()='Log out']") WebElement Logout;
	
	public void setUserName(String uname) {
		textUsername.sendKeys(uname);
	}
	
	public void setPassword(String pswd) {
		textPassword.sendKeys(pswd);
	}
	
	public void clickSubmit() {
		LoginButton.click();
	}
	public void clickLogout()
	{
		Logout.click();
	}
	
	
	
	
	
	
	
	
}
