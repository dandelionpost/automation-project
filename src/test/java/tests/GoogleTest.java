package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class GoogleTest {

    @Test
    public void openGoogle() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Run Chrome in headless mode for CI/CD
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.google.com");
        System.out.println("Title is: " + driver.getTitle());

        driver.quit();
    }
}
