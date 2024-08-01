package andoorathodi.SeleniumTestNGJuly2024;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class proeprtiesSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/Nabeel/eclipse-workspace/SeleniumTestNGJuly2024/data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String urlName = prop.getProperty("url");
		System.out.println("Browser is "+browserName);
		System.out.println("URL is "+urlName);

		prop.setProperty("browser", "edge");
		System.out.println("Browser is "+prop.getProperty("browser"));
		
		FileOutputStream fos = new FileOutputStream("/Users/Nabeel/eclipse-workspace/SeleniumTestNGJuly2024/data.properties");
		prop.store(fos, null);
	}

}
