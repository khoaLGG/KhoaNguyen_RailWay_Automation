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
    private final By _registerBtn = By.xpath("//input[@type='submit']");
    private final By _registerSuccessMsg = By.xpath("//div[@id='content']/p");
    private final By _registerFailedMsg = By.xpath("//p[@class='message error']");
    private final By _passwordFieldMsg = By.xpath("//li[@class='password']/label[@class='validation-error']");
    private final By _PIDMsg = By.xpath("//li[@class='pid-number']/label[@class='validation-error']");

    // Elements
    public WebElement getEmailTextBoxElement() {
        return Constant.WEBDRIVER.findElement(_emailTextBox);
    }

    public WebElement getPasswordTextBoxElement() {
        return Constant.WEBDRIVER.findElement(_passwordTextBox);
    }

    public WebElement getConfirmPasswordTextBoxElement() {
        return Constant.WEBDRIVER.findElement(_confirmPassWordTextBox);
    }

    public WebElement getPIDOrPassPortNumberTextBoxElement() {
        return Constant.WEBDRIVER.findElement(_PIDOrPassPortNumberTextBox);
    }

    public WebElement getRegisterBtnElement() {
        return Constant.WEBDRIVER.findElement(_registerBtn);
    }

    public WebElement getMsgPIDFieldElement() {
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
        return getMsgPIDFieldElement().getText();
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
        this.getRegisterBtnElement().click();
        return email;
    }

    public void fillRegisterInformation(String email, String password, String confirmPW, String PID) {
        this.getEmailTextBoxElement().sendKeys(email);
        this.getPasswordTextBoxElement().sendKeys(password);
        this.getConfirmPasswordTextBoxElement().sendKeys(confirmPW);
        this.getPIDOrPassPortNumberTextBoxElement().sendKeys(PID);
    }

}
