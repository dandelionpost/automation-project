package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        // ✅ Headless options for GitHub Actions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");  // Use new headless mode
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
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
        if (driver != null) {
            driver.quit();
        }
    }
}
