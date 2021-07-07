package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ServerError {
    // Locators
    private final By _serverErrorMsg = By.xpath("//h1");

    // Elements
    public WebElement getServerError(){
        return Constant.WEBDRIVER.findElement(_serverErrorMsg);
    }

    // Methods
    public String getServerErrorMsg() {
       return getServerError().getText();
    }

    public boolean verifyMailBoxDisplayed(){
        boolean check = false;
        if(getServerErrorMsg().contains(Constant.ErrorPage)){
            check = true;
        }
        return check;
    }
}
