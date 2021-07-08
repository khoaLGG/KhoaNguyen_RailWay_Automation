package PageObjects.Railway;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Common.GenerateSuffixOfEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage {


    Utilities utilities = new Utilities();

    // Locators
    private final By _emailTextBox = By.xpath("//input[@id='email']");
    private final By _passwordTextBox = By.xpath("//input[@id='password']");
    private final By _confirmPassWordTextBox = By.xpath("//input[@id='confirmPassword']");
    private final By _PIDOrPassPortNumberTextBox = By.xpath("//input[@id='pid']");
    private final By _registerBtn = By.xpath("//p/input");
    private final By _registerSuccessMsg = By.xpath("//p");
    private final By _registerFailedMsg = By.xpath("//div[@id='content']/p[2]");
    private final By _passwordFieldMsg = By.xpath("//label[2]");
    private final By _PIDMsg = By.xpath("//li[4]/label[2]");

    // Elements
    public WebElement getEmail() {
        return Constant.WEBDRIVER.findElement(_emailTextBox);
    }

    public WebElement getPassword() {
        return Constant.WEBDRIVER.findElement(_passwordTextBox);
    }

    public WebElement getConfirmPassword() {
        return Constant.WEBDRIVER.findElement(_confirmPassWordTextBox);
    }

    public WebElement getPIDOrPassPortNumber() {
        return Constant.WEBDRIVER.findElement(_PIDOrPassPortNumberTextBox);
    }

    public WebElement getRegister() {
        return Constant.WEBDRIVER.findElement(_registerBtn);
    }

    public WebElement getMsgPIDField() {
        return Constant.WEBDRIVER.findElement(_PIDMsg);
    }

    public WebElement getRegisterSuccess() {
        return Constant.WEBDRIVER.findElement(_registerSuccessMsg);
    }

    public WebElement getRegisterFailed() {
        return Constant.WEBDRIVER.findElement(_registerFailedMsg);
    }

    public WebElement getMsgPassWordField() {
        return Constant.WEBDRIVER.findElement(_passwordFieldMsg);
    }

    //Methods
    public String getPIDFieldMsg() {
        return getMsgPIDField().getText();
    }

    public String getPassWordFieldMsg() {
        return getMsgPassWordField().getText();
    }

    public String getRegisterSuccessMsg() {
        return getRegisterSuccess().getText();
    }

    public String getRegisterFailedMsg() {
        return getRegisterFailed().getText();
    }

    public String register(String email, String password, String confirmPW, String PID) {
        return this.submitRegister(email, password, confirmPW, PID);
    }

    public String GenerateEmail() {
        return "Railway+" + utilities.GenRandomString() + "@gmail.com";
    }

    public String submitRegister(String email, String password, String confirmPW, String PID) {
        this.fillRegisterInformation(email, password, confirmPW, PID);
        this.getRegister().click();
        return email;
    }

    public void fillRegisterInformation(String email, String password, String confirmPW, String PID) {
        this.getEmail().sendKeys(email);
        this.getPassword().sendKeys(password);
        this.getConfirmPassword().sendKeys(confirmPW);
        this.getPIDOrPassPortNumber().sendKeys(PID);
    }

}
