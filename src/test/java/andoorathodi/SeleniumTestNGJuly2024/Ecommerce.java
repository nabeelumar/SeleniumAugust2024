package andoorathodi.SeleniumTestNGJuly2024;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productName = "IPHONE 13 PRO";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.get("http://rahulshettyacademy.com/client");
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("nabeelans@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Abcd@123");
		driver.findElement(By.xpath("//input[@id='login']")).click();

		WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(8));
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		WebElement product = products.stream()
				.filter(prod -> prod.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName))
				.findFirst().orElse(null);

		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();

		List<WebElement> orderedItems = driver.findElements(By.cssSelector(".cartSection h3"));

		boolean itemPresent = orderedItems.stream().anyMatch(orderedItem -> orderedItem.getText().equals(productName));
		Assert.assertTrue(itemPresent);
		driver.findElement(By.cssSelector(".totalRow button")).click();

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("[placeholder='Select Country']"))).click().sendKeys("India")
				.build().perform();
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		List<WebElement> countries = driver.findElements(By.cssSelector(".ta-results"));

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

		driver.findElement(By.cssSelector(".action__submit")).click();

		String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(msg);
		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");
	}

}
