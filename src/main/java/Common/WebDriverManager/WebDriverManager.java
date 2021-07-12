package Common.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

    ChromeDriver driver;
    public WebDriverManager(){
        driver = new ChromeDriver();
    }

    public void maximize(){
        driver.manage().window().maximize();
    }


}
