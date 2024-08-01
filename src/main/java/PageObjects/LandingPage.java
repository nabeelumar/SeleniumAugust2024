package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import Abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents{

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#userEmail")
	WebElement email;

	@FindBy(css = "#userPassword")
	WebElement password;

	@FindBy(xpath = "//input[@id='login']")
	WebElement submit;
	
	@FindBy(css=".toast-message")
	WebElement errorMsg;
	
	By erroMsgg = By.cssSelector(".toast-message");

	public void goTo() {

		driver.get("http://rahulshettyacademy.com/client");
	}
	
	

	public ProductCatalogue LoginApplication(String username, String pwd) {

		email.sendKeys(username);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalogue pc = new ProductCatalogue(driver);
		return pc;
	}
	
	public String getErrorMsg() {
		String errorMessage = errorMsg.getText();
		waitElementToAppear(erroMsgg);
		System.out.println(errorMessage);
		return errorMessage;
	}
	
	
}
