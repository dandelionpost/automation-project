package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {
	WebDriver driver;
	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	
	@Test
	public void searchTest() {
		driver.get("https://www.google.com");
		WebElement searchBox = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		searchBox.sendKeys("OpenAI");
		searchBox.submit();
		Assert.assertTrue(driver.getTitle().contains("OpenAI"));
		
	}
	@AfterClass
	public void teardown() {
		driver.quit();
	
	}
	

}
