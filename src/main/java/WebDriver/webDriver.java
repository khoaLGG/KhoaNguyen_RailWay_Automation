package WebDriver;

import Common.Constant.Constant;
import Common.WebDriverManager.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webDriver {

    public static WebDriver driver;
    private static WebDriverManager instance = null;
    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/Webdriver/Executables/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }
    public WebDriverManager getInstance(){
        if(instance == null){
            instance = new WebDriverManager();
        }
        return instance;
    }
    public void maximize(){
        driver.manage().window().maximize();
    }
    public void navigate(String url){
        driver.navigate().to(url);
    }
    public WebElement findElement(String locator){
        By element = null;
        if (locator.contains("xpath")){
            element = By.xpath(locator);
        }
        return driver.findElement(element);
    }
}
