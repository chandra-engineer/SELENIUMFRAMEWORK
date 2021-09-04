package testdata;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EvenMethods {

	public WebElement createWebelement(String xpathType, String Xpathvalue) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(GlobalVariables.driver, GlobalVariables.waitTime);

		try {
			switch (xpathType.toLowerCase()) {
			case "id":
				element = GlobalVariables.driver.findElement(By.id(Xpathvalue));

				wait.until(ExpectedConditions.visibilityOfAllElements(element));
				wait.pollingEvery(200, TimeUnit.MILLISECONDS);

				break;
			case "xpath":
				element = GlobalVariables.driver.findElement(By.xpath(Xpathvalue));
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
				wait.pollingEvery(200, TimeUnit.MILLISECONDS);

				break;
			case "name":
				element = GlobalVariables.driver.findElement(By.name(Xpathvalue));
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
				wait.pollingEvery(200, TimeUnit.MILLISECONDS);

				break;
			case "classname":
				element = GlobalVariables.driver.findElement(By.className(Xpathvalue));
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
				wait.pollingEvery(200, TimeUnit.MILLISECONDS);

				break;
			case "tagname":
				element = GlobalVariables.driver.findElement(By.tagName(Xpathvalue));
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
				wait.pollingEvery(200, TimeUnit.MILLISECONDS);

				break;
			case "linktext":
				element = GlobalVariables.driver.findElement(By.linkText(Xpathvalue));
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
				wait.pollingEvery(200, TimeUnit.MILLISECONDS);

				break;

			case "partiallinktext":
				element = GlobalVariables.driver.findElement(By.partialLinkText(Xpathvalue));
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
				wait.pollingEvery(200, TimeUnit.MILLISECONDS);

				break;
			case "cssselector":
				element = GlobalVariables.driver.findElement(By.cssSelector(Xpathvalue));
				wait.until(ExpectedConditions.visibilityOfAllElements(element));
				wait.pollingEvery(200, TimeUnit.MILLISECONDS);

				break;

			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return element;

	}

	public boolean click(String locator, String locatorValue) {
		boolean Status = false;
		WebDriverWait wait = new WebDriverWait(GlobalVariables.driver, GlobalVariables.waitTime);

		try {

			WebElement element = createWebelement(locator, locatorValue);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.pollingEvery(200, TimeUnit.MILLISECONDS);

			if (element != null) {
				if (element.isDisplayed()) {
					if (element.isEnabled()) {
						element.click();
						Status = true;

					} else {

						System.out.println(
								" Unable to click the element ,because its not enabled  " + element.toString());

					}

				} else {

					System.out
							.println(" Unable to click the element ,because its not displayed  " + element.toString());

				}

			} else {

				System.out.println(" Element value nulll ,Please check the locators ");

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return Status;

	}

	public boolean entertext(String locator, String locatorValue, String textToenter) {

		boolean bStatus = false;
		WebDriverWait wait = new WebDriverWait(GlobalVariables.driver, GlobalVariables.waitTime);

		try {
			
			WebElement element = createWebelement(locator, locatorValue);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.pollingEvery(200, TimeUnit.MILLISECONDS);
			if (element != null) {
				click(locator, locatorValue);
				element.clear();
				click(locator, locatorValue);
				element.sendKeys(textToenter); 
				bStatus = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return bStatus;

	}

	

}
