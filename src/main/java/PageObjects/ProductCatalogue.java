package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By productsBy = By.cssSelector(".mb-3");
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	

	
	By addCart = By.cssSelector(".card-body button:last-of-type");
	By toastContainer = By.cssSelector("#toast-container");

	public List<WebElement> getProducts() {

		waitElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProduct(String productName) {
		
		WebElement product = getProducts().stream()
				.filter(prod -> prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);
		
		return product;
	}
	
	public void addToCart(String productName) {
		
		WebElement product =getProduct(productName);

		product.findElement(addCart).click();
		waitElementToAppear(toastContainer);

		

	}

}
