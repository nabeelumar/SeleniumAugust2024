package Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.CartPage;
import PageObjects.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void waitElementToAppear(By findBy) {
		
		WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(5));
		wd.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cart;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orders;
	
	
	public CartPage goToCart() throws InterruptedException {
		
		Thread.sleep(3000);
		cart.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public OrdersPage goToOrder() {
		
		orders.click();
		OrdersPage op = new OrdersPage(driver);
		return op;
	}

}
