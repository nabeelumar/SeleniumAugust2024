package PageObjects;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> orderedItems;
	
	
	@FindBy(css=".totalRow button")
	WebElement checkout;
	

	
	
	
	public boolean itemPresent(String productName)
	{
		
		boolean itemPresent = orderedItems.stream().anyMatch(orderedItem -> orderedItem.getText().equals(productName));
		return itemPresent;
	}
	
	public CheckOutPage checkOut() {
		checkout.click();
		CheckOutPage cop = new CheckOutPage(driver);
		return cop;
		
	}
}
