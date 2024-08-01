package andoorathodi.SeleniumTestNGJuly2024;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class PersonalLoan {

	
	
	@Test(enabled=true)
	public void laptopLoan() {
		
		System.out.println("This is loan for Laptops");
	}
	
	@Parameters({"brand"})
	@Test(groups= {"Smoke"})
	public void mobileLoan(String brandName) {
		
		System.out.println("This is loan for Mobiles "+brandName);
	}
	
	
	@Test
	public void watchesLoan() {
		
		System.out.println("This is loan for Watches");
	}
	
	
	
}
