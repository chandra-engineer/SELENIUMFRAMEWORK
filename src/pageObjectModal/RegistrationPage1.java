package pageObjectModal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage1 {

	WebDriver driver;

//	@FindBy(how=How.LINK_TEXT,using= "REGISTER") WebElement RegLink;  

	// or
	@FindBy(linkText = "REGISTER")
	WebElement RegLink;

//	@FindBy(name="firstName") WebElement FirstName;   //Syntax 1

	@FindBy(how = How.NAME, using = "firstName")
	WebElement FirstName; // syntax 2

	@FindBy(name = "lastName")
	WebElement LastName;
	@FindBy(name = "phone")
	WebElement Phone;
	@FindBy(id = "userName")
	WebElement Email;
	@FindBy(name = "address1")
	WebElement Address;
	@FindBy(name = "city")
	WebElement City;
	@FindBy(name = "state")
	WebElement State;
	@FindBy(name = "postalCode")
	WebElement PostalCode;
	@FindBy(name = "country")
	WebElement Country;
	@FindBy(name = "email")
	WebElement UserName;
	@FindBy(name = "password")
	WebElement Password;
	@FindBy(name = "confirmPassword")
	WebElement ConfirmPassword;
	@FindBy(name = "submit")
	WebElement SubmitButton;

	RegistrationPage1(WebDriver d) {
		driver = d;
		PageFactory.initElements(d, this);
	}

	public void clickRegLink() {
		RegLink.click();

	}

	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		LastName.sendKeys(lname);
	}

	public void setPhone(String ph) {
		Phone.sendKeys(ph);
	}

	public void setEmail(String email) {
		Email.sendKeys(email);
	}

	public void setAddress(String address) {
		Address.sendKeys(address);
	}

	public void setCity(String city) {
		City.sendKeys(city);
	}
    public void setState(String st)
    {
    	State.sendKeys(st);
    }
    public void setPostalCode(String pc)
    {
    	PostalCode.sendKeys(pc);
    }
    public void setCountry(String country)
    {
    	Country.sendKeys(country);
    }
    
    public void setUserName(String uname)
    {
    	UserName.sendKeys(uname);
    }
    public void setPassword(String pswd)
    {
    	Password.sendKeys(pswd);
    }
    
    public void setConfirmPsassword(String cpc) {
    	ConfirmPassword.sendKeys(cpc);
    }
    public void clickSubmitButton()
    {
    	SubmitButton.click();
    }
    
}
