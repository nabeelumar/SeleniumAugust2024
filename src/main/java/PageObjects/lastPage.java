package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class lastPage {
	

	WebDriver driver;
	
	public  lastPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement msg;
	
	public String getMessage() {
		String message = msg.getText();
		System.out.println(message);
		return message;
	}
	
	 
}


