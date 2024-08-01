package andoorathodi.SeleniumTestNGJuly2024;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOutPage;
import PageObjects.LandingPage;
import PageObjects.OrdersPage;
import PageObjects.ProductCatalogue;
import PageObjects.lastPage;
import TestComponents.BaseTest;

public class StandAloneTest extends BaseTest {

	String productName = "IPHONE 13 PRO";

	@Test(dataProvider="dataTest")
	public void standaloneTest(HashMap<String, String> input) throws InterruptedException {

		ProductCatalogue pc = lp.LoginApplication(input.get("username"), input.get("password"));

		pc.addToCart(productName);
		CartPage cp = pc.goToCart();

		boolean Present = cp.itemPresent(productName);
		AssertJUnit.assertTrue(Present);
		CheckOutPage cop = cp.checkOut();

		cop.selectCountry("India");
		lastPage lap = cop.placeOrder();

		String message = lap.getMessage();
		AssertJUnit.assertEquals(message, "THANKYOU FOR THE ORDER.");

	}

	@Test(dependsOnMethods = { "standaloneTest" })
	public void checkOrder() {

		ProductCatalogue pc = lp.LoginApplication("nabeelans@gmail.com", "Abcd@123");
		OrdersPage op = pc.goToOrder();
		boolean orderPresent = op.checkOrder(productName);
		Assert.assertTrue(orderPresent);

	}
	
	@DataProvider(name="dataTest")
	public Object[][] getData() throws IOException {
		
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/data/credentials.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
		
		/*HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("username", "nabeelans@gmail.com");
		map1.put("password", "Abcd@123");
		
		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("username", "sathish123@gmail.com");
		map2.put("password", "Abcd@123");
		
		return new Object[][] {{map1},{map2}};  */
		
		//return new Object[][] {{"nabeelans@gmail.com","Abcd@123"},{"sathish123@gmail.com","Abcd@123"}};
		
	}

}
