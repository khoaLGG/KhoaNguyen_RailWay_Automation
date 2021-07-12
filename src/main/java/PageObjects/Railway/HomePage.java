package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.WebDriver;
import WebDriver.*;

public class HomePage extends GeneralPage {

    webDriver webDriver = new webDriver();

    // Locators

    // Elements

    // Methods

    public void open() {
        webDriver.navigate(Constant.RAILWAY_URL);
    }
}
