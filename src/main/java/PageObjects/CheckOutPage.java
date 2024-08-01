package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement cntry;
	
	By results = By.cssSelector(".ta-results");
	
	@FindBy(css=".action__submit")
	WebElement order;
	
	public void selectCountry(String countryName) {
		
		Actions a = new Actions(driver);
		a.moveToElement(cntry).click().sendKeys(countryName)
				.build().perform();
		waitElementToAppear(results);
		List<WebElement> countries = driver.findElements(results);

		for (WebElement country : countries) {
			System.out.println(country.getText());
			String txt = country.getText();
			if (country.getText().equalsIgnoreCase(txt)) {
				System.out.println(country.getText());
				System.out.println("TEST");
				country.click();

			} else {

				System.out.println("NO MATCH");
			}
		}

	}
	
	
	public lastPage placeOrder() {
		
		order.click();
		lastPage lap = new lastPage(driver);
		
		return lap;
	}
	
	

}
