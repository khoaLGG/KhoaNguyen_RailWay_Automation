package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import WebDriver.*;

public class GeneralPage {

    webDriver driver = new webDriver();
    WebDriver a;
    // Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By tabBookTicket = By.xpath("//span[contains(.,'Book ticket')]");
    private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By errorMessage = By.xpath("//div[@id='content']/p");
    private final By registerTab = By.xpath("//span[contains(.,'Register')]");
    private final By timeTableTab = By.xpath("//span[contains(.,'Timetable')]");


    // Elements
    public  WebElement getTimeTablePage(){ return Constant.WEBDRIVER.findElement(timeTableTab);}

    public WebElement getRegisterPage() {
        return Constant.WEBDRIVER.findElement(registerTab);
    }

    protected WebElement getLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getWelcomeMessage() {
        return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
    }

    protected WebElement getErrorMessage() {
        return Constant.WEBDRIVER.findElement(errorMessage);
    }

    // Methods

    public boolean isLoggedIn() {
        return Constant.WEBDRIVER.findElements(tabLogout).size() != 0;
    }

    public String getWelcomeMessageText() {
        return this.getWelcomeMessage().getText();
    }

    public String getErrorMsg() {
        return this.getErrorMessage().getText();
    }

    public void goToLoginPage() {
        this.getLogin().click();
    }


    public void gotoRegisterPage() {
        this.getRegisterPage().click();
    }

    public void logout() {
        if (this.isLoggedIn()) {
            this.getLogout().click();
        }
    }

    public void goToBookTicket() {
        this.getBookTicket().click();
    }


    public void goToTimeTablePage() {
        this.getTimeTablePage().click();
    }
}
