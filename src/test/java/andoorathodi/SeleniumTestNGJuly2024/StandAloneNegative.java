package andoorathodi.SeleniumTestNGJuly2024;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.ProductCatalogue;
import TestComponents.BaseTest;


public class StandAloneNegative extends BaseTest{
	
	@Test(groups= {"negative"}, retryAnalyzer=TestComponents.Retry.class)
	public void negativeTest() {
		
		ProductCatalogue pc = lp.LoginApplication("shibil@gmail.com", "Abcd@123");
		pc.addToCart("Hello");
		String errorMessage = lp.getErrorMsg();
		
		//Assert.assertEquals(errorMessage, "Incorrect email or password.");
	
	}
	

}
