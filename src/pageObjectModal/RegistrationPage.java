package pageObjectModal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	WebDriver driver;

	By RegLink = By.linkText("REGISTER");
	By FirstName = By.name("firstName");
	By LastName = By.name("lastName");
	By Phone = By.name("phone");
	By Email = By.id("userName");
	By Adress = By.name("address1");
	By City = By.name("city");
	By State = By.name("state");
	By PostaCode = By.name("postalCode");
	By Country = By.name("country");
	By UserName = By.name("email");
	By Password = By.name("password");
	By ConfirmPassword = By.name("confirmPassword");
	By SubmitButton = By.name("submit");

	RegistrationPage(WebDriver d) {
		driver = d;
	}

	public void clickRegLink() {

		driver.findElement(RegLink).click();
	}

	public void setFirstName(String fname) 
	{
		driver.findElement(FirstName).sendKeys(fname);
	}

	public void setLastName(String lname) {
		driver.findElement(LastName).sendKeys(lname);
	}

	public void setPhone(String ph) {
		driver.findElement(Phone).sendKeys(ph);
	}

	public void setEmail() {
		driver.findElement(Email).click();
	}

	public void setAddress(String addrs) {
		driver.findElement(Adress).sendKeys(addrs);
	}

	public void setCity(String city) {
		driver.findElement(City).sendKeys(city);
	}

	public void  setState(String state) {
		driver.findElement(State).sendKeys(state);
	}

	public void setPostalCode(String pin) {
		driver.findElement(PostaCode).sendKeys(pin);
	}

	public void setCountry(String country) {
		driver.findElement(Country).sendKeys(country);
	}

	public void setUserName(String uname) {
		driver.findElement(UserName).sendKeys(uname);
	}

	public void setPassword(String pswd) {
		driver.findElement(Password).sendKeys(pswd);
	}

	public void ConfirmPassword(String rpswd) {
		driver.findElement(ConfirmPassword).sendKeys(rpswd);
	}

	public void clickSubmitButton() {
		driver.findElement(SubmitButton).click();
	}

}
