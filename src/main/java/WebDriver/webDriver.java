package WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class haha {
    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Webdriver/Executables/chromedriver.exe");
        org.openqa.selenium.WebDriver driver = new ChromeDriver();
        return driver;
    }
}
