package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoogleTest {
	@Test
	public void openGoogle() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Title is:" + driver.getTitle());
		driver.quit();
	
	}
}
