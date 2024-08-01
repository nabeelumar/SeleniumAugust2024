package andoorathodi.SeleniumTestNGJuly2024;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class CarLoanTest {

	
	@Test(groups= {"Smoke"})
	public void toyotaLoan() {
		
		System.out.println("This is loan for Toyotoa");
	}
	
	
	@Test(dependsOnMethods= {"toyotaLoan"})
	public void hondaLoan() {
		
		System.out.println("This is loan for Honda");
	}
	
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data =  new Object[2][2];
		
		data[0][0]="honda";
		data[0][1]="2021";
		data[1][0]="toyotoa";
		data[1][1]="2024";
		return data;
		
		
	}
	
	@Test(dataProvider="getData")
	public void carModels(String brand, String model) {
		
		System.out.println("Brand "+brand+" has model "+model);
	}
	

}
